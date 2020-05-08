import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import {HttpClientModule} from '@angular/common/http';
import { LoginService } from './login.service';


describe('LoginService', () => {
      let service: LoginService;
      beforeEach(() => {
        TestBed.configureTestingModule({
        imports: [HttpClientTestingModule], 
        providers: [LoginService]
        });
        service = TestBed.inject(LoginService);
      });

       it('should be created', () => {
        expect(service).toBeTruthy();
       });

      //  it('should have getData function', () => {
      //   const service: LoginService = TestBed.get(LoginService);
      //   expect(service.getData).toBeTruthy();
      //  });

    });
