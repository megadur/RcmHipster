import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RcmDemoMsSharedModule } from 'app/shared/shared.module';
import { SubscriberComponent } from './subscriber.component';
import { SubscriberDetailComponent } from './subscriber-detail.component';
import { SubscriberUpdateComponent } from './subscriber-update.component';
import { SubscriberDeleteDialogComponent } from './subscriber-delete-dialog.component';
import { subscriberRoute } from './subscriber.route';

@NgModule({
  imports: [RcmDemoMsSharedModule, RouterModule.forChild(subscriberRoute)],
  declarations: [SubscriberComponent, SubscriberDetailComponent, SubscriberUpdateComponent, SubscriberDeleteDialogComponent],
  entryComponents: [SubscriberDeleteDialogComponent],
})
export class RcmDemoMsSubscriberModule {}
