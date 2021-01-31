import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICredentials } from 'app/shared/model/credentials.model';

type EntityResponseType = HttpResponse<ICredentials>;
type EntityArrayResponseType = HttpResponse<ICredentials[]>;

@Injectable({ providedIn: 'root' })
export class CredentialsService {
  public resourceUrl = SERVER_API_URL + 'api/credentials';

  constructor(protected http: HttpClient) {}

  create(credentials: ICredentials): Observable<EntityResponseType> {
    return this.http.post<ICredentials>(this.resourceUrl, credentials, { observe: 'response' });
  }

  update(credentials: ICredentials): Observable<EntityResponseType> {
    return this.http.put<ICredentials>(this.resourceUrl, credentials, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ICredentials>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ICredentials[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
