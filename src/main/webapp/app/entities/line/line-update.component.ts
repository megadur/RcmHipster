import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ILine, Line } from 'app/shared/model/line.model';
import { LineService } from './line.service';

@Component({
  selector: 'jhi-line-update',
  templateUrl: './line-update.component.html',
})
export class LineUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    uar: [],
  });

  constructor(protected lineService: LineService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ line }) => {
      this.updateForm(line);
    });
  }

  updateForm(line: ILine): void {
    this.editForm.patchValue({
      id: line.id,
      uar: line.uar,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const line = this.createFromForm();
    if (line.id !== undefined) {
      this.subscribeToSaveResponse(this.lineService.update(line));
    } else {
      this.subscribeToSaveResponse(this.lineService.create(line));
    }
  }

  private createFromForm(): ILine {
    return {
      ...new Line(),
      id: this.editForm.get(['id'])!.value,
      uar: this.editForm.get(['uar'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ILine>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
