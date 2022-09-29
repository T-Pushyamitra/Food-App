import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url: string = "http://localhost:8080/users"
  constructor(private http:HttpClient) { }

  addEmployee(employee:any){
    return this.http.post(this.url,employee);
  }

}
