import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root',
})
export class StaffService {
  constructor(private http: HttpClient) {}


  // Save Food Order by staff id.
  addNewOrder(order: any,staffId:any) {
    console.log(order)
    return this.http.post(Urls.foodOrderUrl+`${staffId}`, order);
  }

  addOrderItems(items: any,foodOrderId: number) {
    return this.http.post(Urls.itemsUrl+`${foodOrderId}`, items);
  }

  updateFoodOrder(item:any,staffId:any,foodOrderId:number){
    return this.http.put(Urls.foodOrderUpdateUrl+`${staffId}`+"/update/"+`${foodOrderId}`,item)
  }

  getFoodOrderByStaffId(foodOrder:any){
    return this.http.get(Urls.foodOrderUrl+`${localStorage.getItem("id")}`+"/"+foodOrder)
  }

  getFoodOrder(){
    return this.http.get(Urls.foodOrderUrl)
  }


}
