import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RcmHipsterSharedModule } from 'app/shared/shared.module';
import { IpCredentailsComponent } from './ip-credentails.component';
import { IpCredentailsDetailComponent } from './ip-credentails-detail.component';
import { IpCredentailsUpdateComponent } from './ip-credentails-update.component';
import { IpCredentailsDeleteDialogComponent } from './ip-credentails-delete-dialog.component';
import { ipCredentailsRoute } from './ip-credentails.route';

@NgModule({
  imports: [RcmHipsterSharedModule, RouterModule.forChild(ipCredentailsRoute)],
  declarations: [IpCredentailsComponent, IpCredentailsDetailComponent, IpCredentailsUpdateComponent, IpCredentailsDeleteDialogComponent],
  entryComponents: [IpCredentailsDeleteDialogComponent],
})
export class RcmHipsterIpCredentailsModule {}
