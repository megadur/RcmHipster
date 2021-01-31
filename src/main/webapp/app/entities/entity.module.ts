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
      {
        path: 'line',
        loadChildren: () => import('./line/line.module').then(m => m.RcmDemoMsLineModule),
      },
      {
        path: 'credentials',
        loadChildren: () => import('./credentials/credentials.module').then(m => m.RcmDemoMsCredentialsModule),
      },
      {
        path: 'ip-credentails',
        loadChildren: () => import('./ip-credentails/ip-credentails.module').then(m => m.RcmDemoMsIpCredentailsModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class RcmDemoMsEntityModule {}
