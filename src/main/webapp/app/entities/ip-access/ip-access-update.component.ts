import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IIpAccess, IpAccess } from 'app/shared/model/ip-access.model';
import { IpAccessService } from './ip-access.service';

@Component({
  selector: 'jhi-ip-access-update',
  templateUrl: './ip-access-update.component.html',
})
export class IpAccessUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    anschlussbilanzierung: [],
    bssoeorderid: [],
    dnsprofile: [],
    filterid: [],
    fonAktiv: [],
    ipversion: [],
    lineid: [],
    maxdownspeed: [],
    maxsessionduration: [],
    maxupspeed: [],
    mehrfachzugang: [],
    profileid: [],
    rechtAufFesteIpadresse: [],
    toNr: [],
    umtServiceDataOcssubscriptionid: [],
    umtServiceDataThrottledownl3: [],
    umtServiceDataThrottleprofile: [],
    umtServiceDataThrottleupl3: [],
    usecase: [],
    userauthenticationrequired: [],
  });

  constructor(protected ipAccessService: IpAccessService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ipAccess }) => {
      this.updateForm(ipAccess);
    });
  }

  updateForm(ipAccess: IIpAccess): void {
    this.editForm.patchValue({
      id: ipAccess.id,
      anschlussbilanzierung: ipAccess.anschlussbilanzierung,
      bssoeorderid: ipAccess.bssoeorderid,
      dnsprofile: ipAccess.dnsprofile,
      filterid: ipAccess.filterid,
      fonAktiv: ipAccess.fonAktiv,
      ipversion: ipAccess.ipversion,
      lineid: ipAccess.lineid,
      maxdownspeed: ipAccess.maxdownspeed,
      maxsessionduration: ipAccess.maxsessionduration,
      maxupspeed: ipAccess.maxupspeed,
      mehrfachzugang: ipAccess.mehrfachzugang,
      profileid: ipAccess.profileid,
      rechtAufFesteIpadresse: ipAccess.rechtAufFesteIpadresse,
      toNr: ipAccess.toNr,
      umtServiceDataOcssubscriptionid: ipAccess.umtServiceDataOcssubscriptionid,
      umtServiceDataThrottledownl3: ipAccess.umtServiceDataThrottledownl3,
      umtServiceDataThrottleprofile: ipAccess.umtServiceDataThrottleprofile,
      umtServiceDataThrottleupl3: ipAccess.umtServiceDataThrottleupl3,
      usecase: ipAccess.usecase,
      userauthenticationrequired: ipAccess.userauthenticationrequired,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const ipAccess = this.createFromForm();
    if (ipAccess.id !== undefined) {
      this.subscribeToSaveResponse(this.ipAccessService.update(ipAccess));
    } else {
      this.subscribeToSaveResponse(this.ipAccessService.create(ipAccess));
    }
  }

  private createFromForm(): IIpAccess {
    return {
      ...new IpAccess(),
      id: this.editForm.get(['id'])!.value,
      anschlussbilanzierung: this.editForm.get(['anschlussbilanzierung'])!.value,
      bssoeorderid: this.editForm.get(['bssoeorderid'])!.value,
      dnsprofile: this.editForm.get(['dnsprofile'])!.value,
      filterid: this.editForm.get(['filterid'])!.value,
      fonAktiv: this.editForm.get(['fonAktiv'])!.value,
      ipversion: this.editForm.get(['ipversion'])!.value,
      lineid: this.editForm.get(['lineid'])!.value,
      maxdownspeed: this.editForm.get(['maxdownspeed'])!.value,
      maxsessionduration: this.editForm.get(['maxsessionduration'])!.value,
      maxupspeed: this.editForm.get(['maxupspeed'])!.value,
      mehrfachzugang: this.editForm.get(['mehrfachzugang'])!.value,
      profileid: this.editForm.get(['profileid'])!.value,
      rechtAufFesteIpadresse: this.editForm.get(['rechtAufFesteIpadresse'])!.value,
      toNr: this.editForm.get(['toNr'])!.value,
      umtServiceDataOcssubscriptionid: this.editForm.get(['umtServiceDataOcssubscriptionid'])!.value,
      umtServiceDataThrottledownl3: this.editForm.get(['umtServiceDataThrottledownl3'])!.value,
      umtServiceDataThrottleprofile: this.editForm.get(['umtServiceDataThrottleprofile'])!.value,
      umtServiceDataThrottleupl3: this.editForm.get(['umtServiceDataThrottleupl3'])!.value,
      usecase: this.editForm.get(['usecase'])!.value,
      userauthenticationrequired: this.editForm.get(['userauthenticationrequired'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IIpAccess>>): void {
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
