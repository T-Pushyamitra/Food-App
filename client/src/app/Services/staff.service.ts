import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  
  foodOrderUrl: string = "http://localhost:8080/foodOrder/3"
  
  postUrl: string = "http://localhost:8080/foodProduct/"

  itemsUrl: string = "http://localhost:8080/item/3"


  constructor(private http:HttpClient) {  }
 addNewOrder(order:any){
  return this.http.post(this.foodOrderUrl,order);
 }

 addOrderItems(items:any){
  return this.http.post(this.itemsUrl,items);
 }

}
