import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  
  getUrl: string = "http://localhost:8080/foodOrder"
  
  postUrl: string = "http://localhost:8080/foodProduct/"

  deleteUrl: string = "http://localhost:8080/foodProduct/"


  constructor(private http:HttpClient) {  }
 addOrder(product:any){
  return this.http.post(this.postUrl,product)

 }
}
