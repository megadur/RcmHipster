import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RcmHipsterSharedModule } from 'app/shared/shared.module';
import { CredentialsComponent } from './credentials.component';
import { CredentialsDetailComponent } from './credentials-detail.component';
import { CredentialsUpdateComponent } from './credentials-update.component';
import { CredentialsDeleteDialogComponent } from './credentials-delete-dialog.component';
import { credentialsRoute } from './credentials.route';

@NgModule({
  imports: [RcmHipsterSharedModule, RouterModule.forChild(credentialsRoute)],
  declarations: [CredentialsComponent, CredentialsDetailComponent, CredentialsUpdateComponent, CredentialsDeleteDialogComponent],
  entryComponents: [CredentialsDeleteDialogComponent],
})
export class RcmHipsterCredentialsModule {}
