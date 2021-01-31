import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IIpCredentails } from 'app/shared/model/ip-credentails.model';

type EntityResponseType = HttpResponse<IIpCredentails>;
type EntityArrayResponseType = HttpResponse<IIpCredentails[]>;

@Injectable({ providedIn: 'root' })
export class IpCredentailsService {
  public resourceUrl = SERVER_API_URL + 'api/ip-credentails';

  constructor(protected http: HttpClient) {}

  create(ipCredentails: IIpCredentails): Observable<EntityResponseType> {
    return this.http.post<IIpCredentails>(this.resourceUrl, ipCredentails, { observe: 'response' });
  }

  update(ipCredentails: IIpCredentails): Observable<EntityResponseType> {
    return this.http.put<IIpCredentails>(this.resourceUrl, ipCredentails, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IIpCredentails>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IIpCredentails[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
