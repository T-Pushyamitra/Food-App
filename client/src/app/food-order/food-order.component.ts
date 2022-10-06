import { Component, OnInit } from '@angular/core';
import { AnyForUntypedForms } from '@angular/forms';
import { TypesPipe } from '../Pipes/types.pipe';
import { StaffService } from '../Services/staff.service';

@Component({
  selector: 'app-food-order',
  templateUrl: './food-order.component.html',
  styleUrls: ['./food-order.component.css']
})
export class FoodOrderComponent implements OnInit {
  view_tab:any;
  result : any;
  types:any;
  foodOrder:any[] = [];
  constructor(private staff:StaffService,private typeFilter:TypesPipe) { }

  ngOnInit(): void {
    this.staff.getFoodOrder().subscribe((response)=>{
      this.result = response;
      for(let order of this.result.data){
        this.types = this.type(order.item);
        this.foodOrder.push({...order,...this.types})
      }
      console.log(this.foodOrder)
    })
  }

type(order:any){
  var types = this.typeFilter.transform(order)
  console.log(types)
  return types
}


// click
changeTab = (tab: any) =>{
  this.view_tab = tab;
}
  

}
