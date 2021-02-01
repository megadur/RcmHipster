import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IIpCredentails, IpCredentails } from 'app/shared/model/ip-credentails.model';
import { IpCredentailsService } from './ip-credentails.service';
import { IpCredentailsComponent } from './ip-credentails.component';
import { IpCredentailsDetailComponent } from './ip-credentails-detail.component';
import { IpCredentailsUpdateComponent } from './ip-credentails-update.component';

@Injectable({ providedIn: 'root' })
export class IpCredentailsResolve implements Resolve<IIpCredentails> {
  constructor(private service: IpCredentailsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IIpCredentails> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((ipCredentails: HttpResponse<IpCredentails>) => {
          if (ipCredentails.body) {
            return of(ipCredentails.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new IpCredentails());
  }
}

export const ipCredentailsRoute: Routes = [
  {
    path: '',
    component: IpCredentailsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.ipCredentails.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: IpCredentailsDetailComponent,
    resolve: {
      ipCredentails: IpCredentailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.ipCredentails.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: IpCredentailsUpdateComponent,
    resolve: {
      ipCredentails: IpCredentailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.ipCredentails.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: IpCredentailsUpdateComponent,
    resolve: {
      ipCredentails: IpCredentailsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.ipCredentails.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
