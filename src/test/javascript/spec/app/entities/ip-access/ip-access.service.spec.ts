import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { IpAccessService } from 'app/entities/ip-access/ip-access.service';
import { IIpAccess, IpAccess } from 'app/shared/model/ip-access.model';

describe('Service Tests', () => {
  describe('IpAccess Service', () => {
    let injector: TestBed;
    let service: IpAccessService;
    let httpMock: HttpTestingController;
    let elemDefault: IIpAccess;
    let expectedResult: IIpAccess | IIpAccess[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(IpAccessService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new IpAccess(
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

      it('should create a IpAccess', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new IpAccess()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a IpAccess', () => {
        const returnedFromService = Object.assign(
          {
            anschlussbilanzierung: 'BBBBBB',
            bssoeorderid: 'BBBBBB',
            dnsprofile: 'BBBBBB',
            filterid: 'BBBBBB',
            fonAktiv: 'BBBBBB',
            ipversion: 'BBBBBB',
            lineid: 'BBBBBB',
            maxdownspeed: 'BBBBBB',
            maxsessionduration: 'BBBBBB',
            maxupspeed: 'BBBBBB',
            mehrfachzugang: 'BBBBBB',
            profileid: 'BBBBBB',
            rechtAufFesteIpadresse: 'BBBBBB',
            toNr: 'BBBBBB',
            umtServiceDataOcssubscriptionid: 'BBBBBB',
            umtServiceDataThrottledownl3: 'BBBBBB',
            umtServiceDataThrottleprofile: 'BBBBBB',
            umtServiceDataThrottleupl3: 'BBBBBB',
            usecase: 'BBBBBB',
            userauthenticationrequired: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of IpAccess', () => {
        const returnedFromService = Object.assign(
          {
            anschlussbilanzierung: 'BBBBBB',
            bssoeorderid: 'BBBBBB',
            dnsprofile: 'BBBBBB',
            filterid: 'BBBBBB',
            fonAktiv: 'BBBBBB',
            ipversion: 'BBBBBB',
            lineid: 'BBBBBB',
            maxdownspeed: 'BBBBBB',
            maxsessionduration: 'BBBBBB',
            maxupspeed: 'BBBBBB',
            mehrfachzugang: 'BBBBBB',
            profileid: 'BBBBBB',
            rechtAufFesteIpadresse: 'BBBBBB',
            toNr: 'BBBBBB',
            umtServiceDataOcssubscriptionid: 'BBBBBB',
            umtServiceDataThrottledownl3: 'BBBBBB',
            umtServiceDataThrottleprofile: 'BBBBBB',
            umtServiceDataThrottleupl3: 'BBBBBB',
            usecase: 'BBBBBB',
            userauthenticationrequired: 'BBBBBB',
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

      it('should delete a IpAccess', () => {
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
