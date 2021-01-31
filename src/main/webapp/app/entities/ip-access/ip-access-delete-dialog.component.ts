import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IIpAccess } from 'app/shared/model/ip-access.model';
import { IpAccessService } from './ip-access.service';

@Component({
  templateUrl: './ip-access-delete-dialog.component.html',
})
export class IpAccessDeleteDialogComponent {
  ipAccess?: IIpAccess;

  constructor(protected ipAccessService: IpAccessService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.ipAccessService.delete(id).subscribe(() => {
      this.eventManager.broadcast('ipAccessListModification');
      this.activeModal.close();
    });
  }
}
