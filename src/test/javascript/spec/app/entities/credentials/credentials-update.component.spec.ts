import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { RcmHipsterTestModule } from '../../../test.module';
import { CredentialsUpdateComponent } from 'app/entities/credentials/credentials-update.component';
import { CredentialsService } from 'app/entities/credentials/credentials.service';
import { Credentials } from 'app/shared/model/credentials.model';

describe('Component Tests', () => {
  describe('Credentials Management Update Component', () => {
    let comp: CredentialsUpdateComponent;
    let fixture: ComponentFixture<CredentialsUpdateComponent>;
    let service: CredentialsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmHipsterTestModule],
        declarations: [CredentialsUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(CredentialsUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CredentialsUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CredentialsService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Credentials(123);
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
        const entity = new Credentials();
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
