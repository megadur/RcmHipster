import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ICredentials } from 'app/shared/model/credentials.model';
import { CredentialsService } from './credentials.service';
import { CredentialsDeleteDialogComponent } from './credentials-delete-dialog.component';

@Component({
  selector: 'jhi-credentials',
  templateUrl: './credentials.component.html',
})
export class CredentialsComponent implements OnInit, OnDestroy {
  credentials?: ICredentials[];
  eventSubscriber?: Subscription;

  constructor(
    protected credentialsService: CredentialsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.credentialsService.query().subscribe((res: HttpResponse<ICredentials[]>) => (this.credentials = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInCredentials();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: ICredentials): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInCredentials(): void {
    this.eventSubscriber = this.eventManager.subscribe('credentialsListModification', () => this.loadAll());
  }

  delete(credentials: ICredentials): void {
    const modalRef = this.modalService.open(CredentialsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.credentials = credentials;
  }
}
