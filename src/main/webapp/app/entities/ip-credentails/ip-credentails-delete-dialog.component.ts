import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIpCredentails } from 'app/shared/model/ip-credentails.model';
import { IpCredentailsService } from './ip-credentails.service';

@Component({
  templateUrl: './ip-credentails-delete-dialog.component.html',
})
export class IpCredentailsDeleteDialogComponent {
  ipCredentails?: IIpCredentails;

  constructor(
    protected ipCredentailsService: IpCredentailsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.ipCredentailsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('ipCredentailsListModification');
      this.activeModal.close();
    });
  }
}
