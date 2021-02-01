import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { RcmHipsterTestModule } from '../../../test.module';
import { CredentialsComponent } from 'app/entities/credentials/credentials.component';
import { CredentialsService } from 'app/entities/credentials/credentials.service';
import { Credentials } from 'app/shared/model/credentials.model';

describe('Component Tests', () => {
  describe('Credentials Management Component', () => {
    let comp: CredentialsComponent;
    let fixture: ComponentFixture<CredentialsComponent>;
    let service: CredentialsService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmHipsterTestModule],
        declarations: [CredentialsComponent],
      })
        .overrideTemplate(CredentialsComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CredentialsComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CredentialsService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new Credentials(123)],
            headers,
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.credentials && comp.credentials[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
