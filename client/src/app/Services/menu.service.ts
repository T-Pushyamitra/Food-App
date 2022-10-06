import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';
@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http:HttpClient) { }


  // Get Menu By User

  getMenuByUserId(userId : any){
      return this.http.get(Urls.menuUrl+`${userId}`)
  }

  getMenuId(id : any){
    return this.http.get(Urls.getFoodProductOfMenuId+`${id}`);
  }

  isMenuAvailable(id : any){
    return this.http.get(Urls.menuUrl+`${id}`);
  }

  createMenu(id:any){
    return this.http.post(Urls.menuUrl+`${id}`,{})
  }
}
