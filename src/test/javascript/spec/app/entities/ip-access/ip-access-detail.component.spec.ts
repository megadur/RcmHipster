import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RcmDemoMsTestModule } from '../../../test.module';
import { IpAccessDetailComponent } from 'app/entities/ip-access/ip-access-detail.component';
import { IpAccess } from 'app/shared/model/ip-access.model';

describe('Component Tests', () => {
  describe('IpAccess Management Detail Component', () => {
    let comp: IpAccessDetailComponent;
    let fixture: ComponentFixture<IpAccessDetailComponent>;
    const route = ({ data: of({ ipAccess: new IpAccess(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmDemoMsTestModule],
        declarations: [IpAccessDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(IpAccessDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(IpAccessDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load ipAccess on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.ipAccess).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
