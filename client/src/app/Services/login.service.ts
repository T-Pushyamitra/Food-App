import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  getUsersByEmail(email: any) {
    return this.http.get(Urls.userUrl + `${email}`);
  }
}
