import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  url: string = "http://localhost:8080/user/"

  constructor(private http:HttpClient) { }

  getUsersByEmail(email:any){
    // console.log(email)
    return this.http.get(this.url+`${email}`)
  }

}
