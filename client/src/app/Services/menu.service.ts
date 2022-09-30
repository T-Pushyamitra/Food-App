import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Urls } from './devUrls';
@Injectable({
  providedIn: 'root'
})
export class MenuService {

  constructor(private http:HttpClient) { }


  getMenu(){
    return this.http.get(Urls.menuUrl);
  }


}
