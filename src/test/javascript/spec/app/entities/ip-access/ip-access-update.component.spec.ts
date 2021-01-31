import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { RcmDemoMsTestModule } from '../../../test.module';
import { IpAccessUpdateComponent } from 'app/entities/ip-access/ip-access-update.component';
import { IpAccessService } from 'app/entities/ip-access/ip-access.service';
import { IpAccess } from 'app/shared/model/ip-access.model';

describe('Component Tests', () => {
  describe('IpAccess Management Update Component', () => {
    let comp: IpAccessUpdateComponent;
    let fixture: ComponentFixture<IpAccessUpdateComponent>;
    let service: IpAccessService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmDemoMsTestModule],
        declarations: [IpAccessUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(IpAccessUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(IpAccessUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IpAccessService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new IpAccess(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new IpAccess();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
