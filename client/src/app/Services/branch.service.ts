import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  
 

  constructor(private http:HttpClient) { }

  getMenu(id:any){
    return this.http.get(Urls.getFoodProductOfMenuId+`${id}`);
  }

  getMenus(){
    return this.http.get(Urls.menuUrl)
  }

  addFoodProduct(foodProduct : any,id :any){
    return this.http.post(Urls.addFoodProduct+`${id}`,foodProduct,{responseType : "json"});
  }

  deleteFoodProduct(id:any){
    return this.http.delete(Urls.deleteFoodProductById+`${id}`);
  }

}
