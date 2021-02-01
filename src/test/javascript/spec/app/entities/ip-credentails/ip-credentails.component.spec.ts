import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { RcmHipsterTestModule } from '../../../test.module';
import { IpCredentailsComponent } from 'app/entities/ip-credentails/ip-credentails.component';
import { IpCredentailsService } from 'app/entities/ip-credentails/ip-credentails.service';
import { IpCredentails } from 'app/shared/model/ip-credentails.model';

describe('Component Tests', () => {
  describe('IpCredentails Management Component', () => {
    let comp: IpCredentailsComponent;
    let fixture: ComponentFixture<IpCredentailsComponent>;
    let service: IpCredentailsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmHipsterTestModule],
        declarations: [IpCredentailsComponent],
      })
        .overrideTemplate(IpCredentailsComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(IpCredentailsComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IpCredentailsService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new IpCredentails(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.ipCredentails && comp.ipCredentails[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
