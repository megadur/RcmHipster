import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IIpCredentails } from 'app/shared/model/ip-credentails.model';

@Component({
  selector: 'jhi-ip-credentails-detail',
  templateUrl: './ip-credentails-detail.component.html',
})
export class IpCredentailsDetailComponent implements OnInit {
  ipCredentails: IIpCredentails | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ ipCredentails }) => (this.ipCredentails = ipCredentails));
  }

  previousState(): void {
    window.history.back();
  }
}
