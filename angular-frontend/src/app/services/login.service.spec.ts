import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { LoginService } from './login.service';

describe('LoginService', () => {
  let service: LoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({
       imports: [HttpClientTestingModule],
       providers: [LoginService]
    });
    service = TestBed.get(LoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should take a username and password', ()=>{
//       let outputJSON = service.getLogin('billcipher', 'triangle').subscribe().data;
//       expect(outputJSON).toBeTruthy();
//       console.log(outputJSON);
       expect(service.getLogin('billcipher', 'triangle')).toBeTruthy();
       expect(service.userCreds.username).toEqual('billcipher');
       expect(service.userCreds.password).toEqual('triangle');
  });

});
