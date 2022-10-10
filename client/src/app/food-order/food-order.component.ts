import { Component, OnInit } from '@angular/core';
import { AnyForUntypedForms } from '@angular/forms';
import { Router } from '@angular/router';
import { TypesPipe } from '../Pipes/types.pipe';
import { StaffService } from '../Services/staff.service';

@Component({
  selector: 'app-food-order',
  templateUrl: './food-order.component.html',
  styleUrls: ['./food-order.component.css']
})
export class FoodOrderComponent implements OnInit {

  view_tab:any = "";
  result : any;
  types:any;
  foodOrder:any[] = [];
  response: any;
  error: any;
  totalCount: any;
  cookingCount: any;
  deliveredCount:any;
  placedCount:any
  _status = "";

  constructor(private staff:StaffService,private typeFilter:TypesPipe,private router:Router) { }

  ngOnInit(): void {
    this.staff.getFoodOrderByStaffId(localStorage.getItem("id")).subscribe((response)=>{
      this.result = response;
      if(this.result.data != null){

        for(let order of this.result.data){
          this.types = this.type(order.item);
          
          this.foodOrder.push({...order,...this.types})
        }
      }
      this.getCountOfFoodOrders();
      this.getCountOfStatusPlaced();
      this.getCountOfStatusCooking();
      this.getCountOfStatusDelivered();
      })
  }

type(order:any){
  var types = this.typeFilter.transform(order)
  console.log(types)
  return types
}

generateBill(id: any,idx:any) {
  this.update(id,idx)
  this.router.navigate(["/invoice",id])
}

getCountOfFoodOrders(){
  this.staff.getCountOfFoodOrders(localStorage.getItem("id")).subscribe((response)=>{
    this.totalCount = response;
    console.log(this.totalCount)
  })
}
getCountOfStatusPlaced(){
  this.staff.getCountOfStatus("PLACED").subscribe((response)=>{
    this.placedCount = response;
  })
}
getCountOfStatusCooking(){
  this.staff.getCountOfStatus("COOKING").subscribe((response)=>{
    this.cookingCount = response;
  })
}
getCountOfStatusDelivered(){
  this.staff.getCountOfStatus("DELIVERED").subscribe((response)=>{
    this.deliveredCount = response;
  })
}

update(id:any,idx:any){
  if (this.foodOrder[idx].status == "PLACED"){
    this.foodOrder[idx].status = "COOKING"
  }
  
  if (this.foodOrder[idx].status == "COOKING"){
    this.foodOrder[idx].status = "delivered".toUpperCase();
  }

  this.staff.updateFoodOrder(this.foodOrder[idx],localStorage.getItem("id"),id).subscribe((response)=>{
    this.response = response
    // if(this.response.data != null){
    //   this.router.navigate(["/foodorders",localStorage.getItem("id")])
    // }
  })
}

status(status:any){
  this._status = status
}
// click
changeTab = (tab: any) =>{
  if(this.view_tab === tab)
  {
    this.view_tab = ""
  }
  else{
    this.view_tab = tab;
  }
}
  

}
