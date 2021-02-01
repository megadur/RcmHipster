import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RcmHipsterTestModule } from '../../../test.module';
import { CredentialsDetailComponent } from 'app/entities/credentials/credentials-detail.component';
import { Credentials } from 'app/shared/model/credentials.model';

describe('Component Tests', () => {
  describe('Credentials Management Detail Component', () => {
    let comp: CredentialsDetailComponent;
    let fixture: ComponentFixture<CredentialsDetailComponent>;
    const route = ({ data: of({ credentials: new Credentials(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [RcmHipsterTestModule],
        declarations: [CredentialsDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(CredentialsDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CredentialsDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load credentials on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.credentials).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
