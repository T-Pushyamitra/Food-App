import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BranchService {

  
  getUrl: string = "http://localhost:8080/branch/1"
  
  postUrl: string = "http://localhost:8080/foodProduct/1"

  deleteUrl: string = "http://localhost:8080/foodProduct/"

  constructor(private http:HttpClient) { }

  getMenu(){
    return this.http.get(this.getUrl);
  }

  addFoodProduct(foodProduct : any){
    return this.http.post(this.postUrl,foodProduct,{responseType : "json"});
  }

  deleteFoodProduct(id:any){
    return this.http.delete(this.deleteUrl+`${id}`);
  }

}
