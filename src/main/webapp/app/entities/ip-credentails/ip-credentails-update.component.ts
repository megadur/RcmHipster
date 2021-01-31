import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IIpCredentails, IpCredentails } from 'app/shared/model/ip-credentails.model';
import { IpCredentailsService } from './ip-credentails.service';

@Component({
  selector: 'jhi-ip-credentails-update',
  templateUrl: './ip-credentails-update.component.html',
})
export class IpCredentailsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    toNr: [],
  });

  constructor(protected ipCredentailsService: IpCredentailsService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ipCredentails }) => {
      this.updateForm(ipCredentails);
    });
  }

  updateForm(ipCredentails: IIpCredentails): void {
    this.editForm.patchValue({
      id: ipCredentails.id,
      toNr: ipCredentails.toNr,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const ipCredentails = this.createFromForm();
    if (ipCredentails.id !== undefined) {
      this.subscribeToSaveResponse(this.ipCredentailsService.update(ipCredentails));
    } else {
      this.subscribeToSaveResponse(this.ipCredentailsService.create(ipCredentails));
    }
  }

  private createFromForm(): IIpCredentails {
    return {
      ...new IpCredentails(),
      id: this.editForm.get(['id'])!.value,
      toNr: this.editForm.get(['toNr'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IIpCredentails>>): void {
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
