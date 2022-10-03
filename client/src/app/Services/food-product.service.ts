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

}
