import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IIpAccess } from 'app/shared/model/ip-access.model';

@Component({
  selector: 'jhi-ip-access-detail',
  templateUrl: './ip-access-detail.component.html',
})
export class IpAccessDetailComponent implements OnInit {
  ipAccess: IIpAccess | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ipAccess }) => (this.ipAccess = ipAccess));
  }

  previousState(): void {
    window.history.back();
  }
}
