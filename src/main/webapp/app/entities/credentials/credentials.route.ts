import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ICredentials, Credentials } from 'app/shared/model/credentials.model';
import { CredentialsService } from './credentials.service';
import { CredentialsComponent } from './credentials.component';
import { CredentialsDetailComponent } from './credentials-detail.component';
import { CredentialsUpdateComponent } from './credentials-update.component';

@Injectable({ providedIn: 'root' })
export class CredentialsResolve implements Resolve<ICredentials> {
  constructor(private service: CredentialsService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<ICredentials> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((credentials: HttpResponse<Credentials>) => {
          if (credentials.body) {
            return of(credentials.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new Credentials());
  }
}

export const credentialsRoute: Routes = [
  {
    path: '',
    component: CredentialsComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.credentials.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: CredentialsDetailComponent,
    resolve: {
      credentials: CredentialsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.credentials.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: CredentialsUpdateComponent,
    resolve: {
      credentials: CredentialsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.credentials.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: CredentialsUpdateComponent,
    resolve: {
      credentials: CredentialsResolve,
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'rcmHipsterApp.credentials.home.title',
    },
    canActivate: [UserRouteAccessService],
  },
];
