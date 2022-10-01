import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root',
})
export class StaffService {
  constructor(private http: HttpClient) {}
  addNewOrder(order: any) {
    return this.http.post(Urls.foodOrderUrl, order);
  }

  addOrderItems(items: any,foodOrderId: number) {
    return this.http.post(Urls.itemsUrl+`${foodOrderId}`, items);
  }

  updateFoodOrder(item:any,foodOrderId:number){
    return this.http.put(Urls.foodOrderUpdateUrl+`${foodOrderId}`,item)
  }
}
