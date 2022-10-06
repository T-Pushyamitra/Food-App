import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Urls} from "./devUrls";
@Injectable({
  providedIn: 'root'
})
export class FoodProductService {

  constructor(private http: HttpClient) { }



  getFoodProductByname(value:any){
      return this.http.get(Urls.foodOrderUrl+`${value}`);
  }

  // Get food products by menu id
  getFoodProductsByMenuId(menuId: any){
    return this.http.get(Urls.getFoodProductOfMenuId+`${menuId}`)
  }

  // Add Food Products By Menu Id
  addFoodproductsByMenuid(request:any,menuId:any){
    return this.http.post(Urls.addFoodProduct+`${menuId}`,request)
  }

  // Delete Food products By food product id
  deleteFoodproductById(fooproductId:any){
    return this.http.delete(Urls.deleteFoodProductById+`${fooproductId}`)
  }
  
}
