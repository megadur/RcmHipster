import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RcmHipsterSharedModule } from 'app/shared/shared.module';
import { IpAccessComponent } from './ip-access.component';
import { IpAccessDetailComponent } from './ip-access-detail.component';
import { IpAccessUpdateComponent } from './ip-access-update.component';
import { IpAccessDeleteDialogComponent } from './ip-access-delete-dialog.component';
import { ipAccessRoute } from './ip-access.route';

@NgModule({
  imports: [RcmHipsterSharedModule, RouterModule.forChild(ipAccessRoute)],
  declarations: [IpAccessComponent, IpAccessDetailComponent, IpAccessUpdateComponent, IpAccessDeleteDialogComponent],
  entryComponents: [IpAccessDeleteDialogComponent],
})
export class RcmHipsterIpAccessModule {}
