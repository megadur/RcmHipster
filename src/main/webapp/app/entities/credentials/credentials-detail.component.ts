import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICredentials } from 'app/shared/model/credentials.model';

@Component({
  selector: 'jhi-credentials-detail',
  templateUrl: './credentials-detail.component.html',
})
export class CredentialsDetailComponent implements OnInit {
  credentials: ICredentials | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ credentials }) => (this.credentials = credentials));
  }

  previousState(): void {
    window.history.back();
  }
}
