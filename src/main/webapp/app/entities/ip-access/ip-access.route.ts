import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IIpAccess, IpAccess } from 'app/shared/model/ip-access.model';
import { IpAccessService } from './ip-access.service';
import { IpAccessComponent } from './ip-access.component';
import { IpAccessDetailComponent } from './ip-access-detail.component';
import { IpAccessUpdateComponent } from './ip-access-update.component';

@Injectable({ providedIn: 'root' })
export class IpAccessResolve implements Resolve<IIpAccess> {
  constructor(private service: IpAccessService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IIpAccess> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((ipAccess: HttpResponse<IpAccess>) => {
          if (ipAccess.body) {
            return of(ipAccess.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new IpAccess());
  }
}

export const ipAccessRoute: Routes = [
  {
    path: '',
    component: IpAccessComponent,
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'rcmDemoMsApp.ipAccess.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: IpAccessDetailComponent,
    resolve: {
      ipAccess: IpAccessResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmDemoMsApp.ipAccess.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: IpAccessUpdateComponent,
    resolve: {
      ipAccess: IpAccessResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmDemoMsApp.ipAccess.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: IpAccessUpdateComponent,
    resolve: {
      ipAccess: IpAccessResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmDemoMsApp.ipAccess.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
