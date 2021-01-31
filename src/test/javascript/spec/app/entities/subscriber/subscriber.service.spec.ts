import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { SubscriberService } from 'app/entities/subscriber/subscriber.service';
import { ISubscriber, Subscriber } from 'app/shared/model/subscriber.model';

describe('Service Tests', () => {
  describe('Subscriber Service', () => {
    let injector: TestBed;
    let service: SubscriberService;
    let httpMock: HttpTestingController;
    let elemDefault: ISubscriber;
    let expectedResult: ISubscriber | ISubscriber[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(SubscriberService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new Subscriber(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a Subscriber', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new Subscriber()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a Subscriber', () => {
        const returnedFromService = Object.assign(
          {
            asskeng: 'BBBBBB',
            calid: 'BBBBBB',
            dlgipv6Prefix: 'BBBBBB',
            dlgipv6Prefixlen: 'BBBBBB',
            dnsProfile: 'BBBBBB',
            errorelement: 'BBBBBB',
            errormessage: 'BBBBBB',
            errorvalue: 'BBBBBB',
            filterid: 'BBBBBB',
            frmdipv6Prefix: 'BBBBBB',
            frmdipv6Prefixlen: 'BBBBBB',
            ipaddress: 'BBBBBB',
            ipnetmask: 'BBBBBB',
            ipversion: 'BBBBBB',
            keyid: 'BBBBBB',
            maxDownL3: 'BBBBBB',
            maxSessionDuration: 'BBBBBB',
            maxUpL3: 'BBBBBB',
            mfzg: 'BBBBBB',
            msisdn: 'BBBBBB',
            netprofileid: 'BBBBBB',
            origin: 'BBBBBB',
            passwort: 'BBBBBB',
            passwortEnc: 'BBBBBB',
            policyGroup: 'BBBBBB',
            profilset: 'BBBBBB',
            rc: 'BBBBBB',
            rectime: 'BBBBBB',
            requestID: 'BBBBBB',
            reserveprefix: 'BBBBBB',
            returnmessage: 'BBBBBB',
            rsptime: 'BBBBBB',
            tlnnr: 'BBBBBB',
            tlnsps: 'BBBBBB',
            tunnelProfile: 'BBBBBB',
            umtServiceData: 'BBBBBB',
            userAuthRequired: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of Subscriber', () => {
        const returnedFromService = Object.assign(
          {
            asskeng: 'BBBBBB',
            calid: 'BBBBBB',
            dlgipv6Prefix: 'BBBBBB',
            dlgipv6Prefixlen: 'BBBBBB',
            dnsProfile: 'BBBBBB',
            errorelement: 'BBBBBB',
            errormessage: 'BBBBBB',
            errorvalue: 'BBBBBB',
            filterid: 'BBBBBB',
            frmdipv6Prefix: 'BBBBBB',
            frmdipv6Prefixlen: 'BBBBBB',
            ipaddress: 'BBBBBB',
            ipnetmask: 'BBBBBB',
            ipversion: 'BBBBBB',
            keyid: 'BBBBBB',
            maxDownL3: 'BBBBBB',
            maxSessionDuration: 'BBBBBB',
            maxUpL3: 'BBBBBB',
            mfzg: 'BBBBBB',
            msisdn: 'BBBBBB',
            netprofileid: 'BBBBBB',
            origin: 'BBBBBB',
            passwort: 'BBBBBB',
            passwortEnc: 'BBBBBB',
            policyGroup: 'BBBBBB',
            profilset: 'BBBBBB',
            rc: 'BBBBBB',
            rectime: 'BBBBBB',
            requestID: 'BBBBBB',
            reserveprefix: 'BBBBBB',
            returnmessage: 'BBBBBB',
            rsptime: 'BBBBBB',
            tlnnr: 'BBBBBB',
            tlnsps: 'BBBBBB',
            tunnelProfile: 'BBBBBB',
            umtServiceData: 'BBBBBB',
            userAuthRequired: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a Subscriber', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
