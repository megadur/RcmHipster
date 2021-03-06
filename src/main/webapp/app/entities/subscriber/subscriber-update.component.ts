import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ISubscriber, Subscriber } from 'app/shared/model/subscriber.model';
import { SubscriberService } from './subscriber.service';

@Component({
  selector: 'jhi-subscriber-update',
  templateUrl: './subscriber-update.component.html',
})
export class SubscriberUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    asskeng: [],
    calid: [],
    dnsProfile: [],
    errorelement: [],
    errormessage: [],
    errorvalue: [],
    ipversion: [],
    keyid: [],
    maxDownL3: [],
    maxSessionDuration: [],
    maxUpL3: [],
    mfzg: [],
    netprofileid: [],
    origin: [],
    passwort: [],
    passwortEnc: [],
    policyGroup: [],
    profilset: [],
    rc: [],
    rectime: [],
    requestID: [],
    returnmessage: [],
    rsptime: [],
    tlnnr: [],
    tlnsps: [],
    userAuthRequired: [],
  });

  constructor(protected subscriberService: SubscriberService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ subscriber }) => {
      this.updateForm(subscriber);
    });
  }

  updateForm(subscriber: ISubscriber): void {
    this.editForm.patchValue({
      id: subscriber.id,
      asskeng: subscriber.asskeng,
      calid: subscriber.calid,
      dnsProfile: subscriber.dnsProfile,
      errorelement: subscriber.errorelement,
      errormessage: subscriber.errormessage,
      errorvalue: subscriber.errorvalue,
      ipversion: subscriber.ipversion,
      keyid: subscriber.keyid,
      maxDownL3: subscriber.maxDownL3,
      maxSessionDuration: subscriber.maxSessionDuration,
      maxUpL3: subscriber.maxUpL3,
      mfzg: subscriber.mfzg,
      netprofileid: subscriber.netprofileid,
      origin: subscriber.origin,
      passwort: subscriber.passwort,
      passwortEnc: subscriber.passwortEnc,
      policyGroup: subscriber.policyGroup,
      profilset: subscriber.profilset,
      rc: subscriber.rc,
      rectime: subscriber.rectime,
      requestID: subscriber.requestID,
      returnmessage: subscriber.returnmessage,
      rsptime: subscriber.rsptime,
      tlnnr: subscriber.tlnnr,
      tlnsps: subscriber.tlnsps,
      userAuthRequired: subscriber.userAuthRequired,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const subscriber = this.createFromForm();
    if (subscriber.id !== undefined) {
      this.subscribeToSaveResponse(this.subscriberService.update(subscriber));
    } else {
      this.subscribeToSaveResponse(this.subscriberService.create(subscriber));
    }
  }

  private createFromForm(): ISubscriber {
    return {
      ...new Subscriber(),
      id: this.editForm.get(['id'])!.value,
      asskeng: this.editForm.get(['asskeng'])!.value,
      calid: this.editForm.get(['calid'])!.value,
      dnsProfile: this.editForm.get(['dnsProfile'])!.value,
      errorelement: this.editForm.get(['errorelement'])!.value,
      errormessage: this.editForm.get(['errormessage'])!.value,
      errorvalue: this.editForm.get(['errorvalue'])!.value,
      ipversion: this.editForm.get(['ipversion'])!.value,
      keyid: this.editForm.get(['keyid'])!.value,
      maxDownL3: this.editForm.get(['maxDownL3'])!.value,
      maxSessionDuration: this.editForm.get(['maxSessionDuration'])!.value,
      maxUpL3: this.editForm.get(['maxUpL3'])!.value,
      mfzg: this.editForm.get(['mfzg'])!.value,
      netprofileid: this.editForm.get(['netprofileid'])!.value,
      origin: this.editForm.get(['origin'])!.value,
      passwort: this.editForm.get(['passwort'])!.value,
      passwortEnc: this.editForm.get(['passwortEnc'])!.value,
      policyGroup: this.editForm.get(['policyGroup'])!.value,
      profilset: this.editForm.get(['profilset'])!.value,
      rc: this.editForm.get(['rc'])!.value,
      rectime: this.editForm.get(['rectime'])!.value,
      requestID: this.editForm.get(['requestID'])!.value,
      returnmessage: this.editForm.get(['returnmessage'])!.value,
      rsptime: this.editForm.get(['rsptime'])!.value,
      tlnnr: this.editForm.get(['tlnnr'])!.value,
      tlnsps: this.editForm.get(['tlnsps'])!.value,
      userAuthRequired: this.editForm.get(['userAuthRequired'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ISubscriber>>): void {
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
