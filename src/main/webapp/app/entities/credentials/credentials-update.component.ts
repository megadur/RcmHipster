import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICredentials, Credentials } from 'app/shared/model/credentials.model';
import { CredentialsService } from './credentials.service';

@Component({
  selector: 'jhi-credentials-update',
  templateUrl: './credentials-update.component.html',
})
export class CredentialsUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    tonr: [],
    ask: [],
    password: [],
  });

  constructor(protected credentialsService: CredentialsService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ credentials }) => {
      this.updateForm(credentials);
    });
  }

  updateForm(credentials: ICredentials): void {
    this.editForm.patchValue({
      id: credentials.id,
      tonr: credentials.tonr,
      ask: credentials.ask,
      password: credentials.password,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const credentials = this.createFromForm();
    if (credentials.id !== undefined) {
      this.subscribeToSaveResponse(this.credentialsService.update(credentials));
    } else {
      this.subscribeToSaveResponse(this.credentialsService.create(credentials));
    }
  }

  private createFromForm(): ICredentials {
    return {
      ...new Credentials(),
      id: this.editForm.get(['id'])!.value,
      tonr: this.editForm.get(['tonr'])!.value,
      ask: this.editForm.get(['ask'])!.value,
      password: this.editForm.get(['password'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICredentials>>): void {
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
