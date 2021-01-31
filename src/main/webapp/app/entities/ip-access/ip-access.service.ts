import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IIpAccess } from 'app/shared/model/ip-access.model';

type EntityResponseType = HttpResponse<IIpAccess>;
type EntityArrayResponseType = HttpResponse<IIpAccess[]>;

@Injectable({ providedIn: 'root' })
export class IpAccessService {
  public resourceUrl = SERVER_API_URL + 'api/ip-accesses';

  constructor(protected http: HttpClient) {}

  create(ipAccess: IIpAccess): Observable<EntityResponseType> {
    return this.http.post<IIpAccess>(this.resourceUrl, ipAccess, { observe: 'response' });
  }

  update(ipAccess: IIpAccess): Observable<EntityResponseType> {
    return this.http.put<IIpAccess>(this.resourceUrl, ipAccess, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IIpAccess>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IIpAccess[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
