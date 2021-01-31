import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ISubscriber } from 'app/shared/model/subscriber.model';

type EntityResponseType = HttpResponse<ISubscriber>;
type EntityArrayResponseType = HttpResponse<ISubscriber[]>;

@Injectable({ providedIn: 'root' })
export class SubscriberService {
  public resourceUrl = SERVER_API_URL + 'api/subscribers';

  constructor(protected http: HttpClient) {}

  create(subscriber: ISubscriber): Observable<EntityResponseType> {
    return this.http.post<ISubscriber>(this.resourceUrl, subscriber, { observe: 'response' });
  }

  update(subscriber: ISubscriber): Observable<EntityResponseType> {
    return this.http.put<ISubscriber>(this.resourceUrl, subscriber, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<ISubscriber>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<ISubscriber[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}
