import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RcmDemoMsTestModule } from '../../../test.module';
import { IpCredentailsDetailComponent } from 'app/entities/ip-credentails/ip-credentails-detail.component';
import { IpCredentails } from 'app/shared/model/ip-credentails.model';

describe('Component Tests', () => {
  describe('IpCredentails Management Detail Component', () => {
    let comp: IpCredentailsDetailComponent;
    let fixture: ComponentFixture<IpCredentailsDetailComponent>;
    const route = ({ data: of({ ipCredentails: new IpCredentails(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmDemoMsTestModule],
        declarations: [IpCredentailsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(IpCredentailsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(IpCredentailsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load ipCredentails on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.ipCredentails).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
