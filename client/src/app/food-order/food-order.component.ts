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

  constructor(private staff:StaffService,private typeFilter:TypesPipe,private router:Router) { }

  ngOnInit(): void {
    this.staff.getFoodOrderByStaffId(localStorage.getItem("id")).subscribe((response)=>{
      this.result = response;
      for(let order of this.result.data){
        this.types = this.type(order.item);

        this.foodOrder.push({...order,...this.types})
      }
    })
  }

type(order:any){
  var types = this.typeFilter.transform(order)
  console.log(types)
  return types
}

generateBill(id: any) {
  this.router.navigate(["/invoice",id])
}


// click
changeTab = (tab: any) =>{
  if(this.view_tab === tab){this.view_tab = null}
  this.view_tab = tab;
}
  

}
