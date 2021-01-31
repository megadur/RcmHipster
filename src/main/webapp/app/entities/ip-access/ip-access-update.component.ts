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
    coanakreaction: [],
    credentialsrequested: [],
    delegatedipv6prefix: [],
    delegatedipv6prefixlength: [],
    dnsprofile: [],
    filterid: [],
    fonAktiv: [],
    framedipv6prefix: [],
    framedipv6prefixlength: [],
    haMSISDN: [],
    influencesession: [],
    iptvEnabled: [],
    ipv4address: [],
    ipv4netmask: [],
    ipversion: [],
    lineid: [],
    maxdownspeed: [],
    maxsessionduration: [],
    maxupspeed: [],
    mehrfachzugang: [],
    profileid: [],
    profilset: [],
    rechtAufFesteIpadresse: [],
    reserveprefix: [],
    teilnehmersperre: [],
    terminationprofile: [],
    toNr: [],
    tunnelprofile: [],
    umtServiceDataOcssubscriptionid: [],
    umtServiceDataThrottledownl3: [],
    umtServiceDataThrottleprofile: [],
    umtServiceDataThrottleupl3: [],
    usecase: [],
    userauthenticationrequired: [],
    voipIsPresent: [],
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
      coanakreaction: ipAccess.coanakreaction,
      credentialsrequested: ipAccess.credentialsrequested,
      delegatedipv6prefix: ipAccess.delegatedipv6prefix,
      delegatedipv6prefixlength: ipAccess.delegatedipv6prefixlength,
      dnsprofile: ipAccess.dnsprofile,
      filterid: ipAccess.filterid,
      fonAktiv: ipAccess.fonAktiv,
      framedipv6prefix: ipAccess.framedipv6prefix,
      framedipv6prefixlength: ipAccess.framedipv6prefixlength,
      haMSISDN: ipAccess.haMSISDN,
      influencesession: ipAccess.influencesession,
      iptvEnabled: ipAccess.iptvEnabled,
      ipv4address: ipAccess.ipv4address,
      ipv4netmask: ipAccess.ipv4netmask,
      ipversion: ipAccess.ipversion,
      lineid: ipAccess.lineid,
      maxdownspeed: ipAccess.maxdownspeed,
      maxsessionduration: ipAccess.maxsessionduration,
      maxupspeed: ipAccess.maxupspeed,
      mehrfachzugang: ipAccess.mehrfachzugang,
      profileid: ipAccess.profileid,
      profilset: ipAccess.profilset,
      rechtAufFesteIpadresse: ipAccess.rechtAufFesteIpadresse,
      reserveprefix: ipAccess.reserveprefix,
      teilnehmersperre: ipAccess.teilnehmersperre,
      terminationprofile: ipAccess.terminationprofile,
      toNr: ipAccess.toNr,
      tunnelprofile: ipAccess.tunnelprofile,
      umtServiceDataOcssubscriptionid: ipAccess.umtServiceDataOcssubscriptionid,
      umtServiceDataThrottledownl3: ipAccess.umtServiceDataThrottledownl3,
      umtServiceDataThrottleprofile: ipAccess.umtServiceDataThrottleprofile,
      umtServiceDataThrottleupl3: ipAccess.umtServiceDataThrottleupl3,
      usecase: ipAccess.usecase,
      userauthenticationrequired: ipAccess.userauthenticationrequired,
      voipIsPresent: ipAccess.voipIsPresent,
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
      coanakreaction: this.editForm.get(['coanakreaction'])!.value,
      credentialsrequested: this.editForm.get(['credentialsrequested'])!.value,
      delegatedipv6prefix: this.editForm.get(['delegatedipv6prefix'])!.value,
      delegatedipv6prefixlength: this.editForm.get(['delegatedipv6prefixlength'])!.value,
      dnsprofile: this.editForm.get(['dnsprofile'])!.value,
      filterid: this.editForm.get(['filterid'])!.value,
      fonAktiv: this.editForm.get(['fonAktiv'])!.value,
      framedipv6prefix: this.editForm.get(['framedipv6prefix'])!.value,
      framedipv6prefixlength: this.editForm.get(['framedipv6prefixlength'])!.value,
      haMSISDN: this.editForm.get(['haMSISDN'])!.value,
      influencesession: this.editForm.get(['influencesession'])!.value,
      iptvEnabled: this.editForm.get(['iptvEnabled'])!.value,
      ipv4address: this.editForm.get(['ipv4address'])!.value,
      ipv4netmask: this.editForm.get(['ipv4netmask'])!.value,
      ipversion: this.editForm.get(['ipversion'])!.value,
      lineid: this.editForm.get(['lineid'])!.value,
      maxdownspeed: this.editForm.get(['maxdownspeed'])!.value,
      maxsessionduration: this.editForm.get(['maxsessionduration'])!.value,
      maxupspeed: this.editForm.get(['maxupspeed'])!.value,
      mehrfachzugang: this.editForm.get(['mehrfachzugang'])!.value,
      profileid: this.editForm.get(['profileid'])!.value,
      profilset: this.editForm.get(['profilset'])!.value,
      rechtAufFesteIpadresse: this.editForm.get(['rechtAufFesteIpadresse'])!.value,
      reserveprefix: this.editForm.get(['reserveprefix'])!.value,
      teilnehmersperre: this.editForm.get(['teilnehmersperre'])!.value,
      terminationprofile: this.editForm.get(['terminationprofile'])!.value,
      toNr: this.editForm.get(['toNr'])!.value,
      tunnelprofile: this.editForm.get(['tunnelprofile'])!.value,
      umtServiceDataOcssubscriptionid: this.editForm.get(['umtServiceDataOcssubscriptionid'])!.value,
      umtServiceDataThrottledownl3: this.editForm.get(['umtServiceDataThrottledownl3'])!.value,
      umtServiceDataThrottleprofile: this.editForm.get(['umtServiceDataThrottleprofile'])!.value,
      umtServiceDataThrottleupl3: this.editForm.get(['umtServiceDataThrottleupl3'])!.value,
      usecase: this.editForm.get(['usecase'])!.value,
      userauthenticationrequired: this.editForm.get(['userauthenticationrequired'])!.value,
      voipIsPresent: this.editForm.get(['voipIsPresent'])!.value,
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
