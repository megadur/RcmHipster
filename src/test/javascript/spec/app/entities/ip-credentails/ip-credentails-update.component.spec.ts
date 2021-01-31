import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { RcmDemoMsTestModule } from '../../../test.module';
import { IpCredentailsUpdateComponent } from 'app/entities/ip-credentails/ip-credentails-update.component';
import { IpCredentailsService } from 'app/entities/ip-credentails/ip-credentails.service';
import { IpCredentails } from 'app/shared/model/ip-credentails.model';

describe('Component Tests', () => {
  describe('IpCredentails Management Update Component', () => {
    let comp: IpCredentailsUpdateComponent;
    let fixture: ComponentFixture<IpCredentailsUpdateComponent>;
    let service: IpCredentailsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmDemoMsTestModule],
        declarations: [IpCredentailsUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(IpCredentailsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(IpCredentailsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(IpCredentailsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new IpCredentails(123);
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
        const entity = new IpCredentails();
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
