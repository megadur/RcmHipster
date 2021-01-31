import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IIpCredentails } from 'app/shared/model/ip-credentails.model';
import { IpCredentailsService } from './ip-credentails.service';
import { IpCredentailsDeleteDialogComponent } from './ip-credentails-delete-dialog.component';

@Component({
  selector: 'jhi-ip-credentails',
  templateUrl: './ip-credentails.component.html',
})
export class IpCredentailsComponent implements OnInit, OnDestroy {
  ipCredentails?: IIpCredentails[];
  eventSubscriber?: Subscription;

  constructor(
    protected ipCredentailsService: IpCredentailsService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.ipCredentailsService.query().subscribe((res: HttpResponse<IIpCredentails[]>) => (this.ipCredentails = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInIpCredentails();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IIpCredentails): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInIpCredentails(): void {
    this.eventSubscriber = this.eventManager.subscribe('ipCredentailsListModification', () => this.loadAll());
  }

  delete(ipCredentails: IIpCredentails): void {
    const modalRef = this.modalService.open(IpCredentailsDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.ipCredentails = ipCredentails;
  }
}
