import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICredentials } from 'app/shared/model/credentials.model';
import { CredentialsService } from './credentials.service';

@Component({
  templateUrl: './credentials-delete-dialog.component.html',
})
export class CredentialsDeleteDialogComponent {
  credentials?: ICredentials;

  constructor(
    protected credentialsService: CredentialsService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.credentialsService.delete(id).subscribe(() => {
      this.eventManager.broadcast('credentialsListModification');
      this.activeModal.close();
    });
  }
}
