import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  addEmployee(employee:any){
    return this.http.post(Urls.register,employee);
  }
  
  getUserByEmail(user:any){
    return this.http.get(Urls.user+`${user}`);
  }

  loggedIn(){
    return !!localStorage.getItem("id");
  }

}
