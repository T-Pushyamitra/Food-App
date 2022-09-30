import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Urls} from './devUrls'

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  
  constructor(private http:HttpClient) { }

  addEmployee(employee:any){
    return this.http.post(Urls.userUrl,employee);
  }

}
