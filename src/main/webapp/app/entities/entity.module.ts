import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'ip-access',
        loadChildren: () => import('./ip-access/ip-access.module').then(m => m.RcmDemoMsIpAccessModule),
      },
      {
        path: 'subscriber',
        loadChildren: () => import('./subscriber/subscriber.module').then(m => m.RcmDemoMsSubscriberModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class RcmDemoMsEntityModule {}
