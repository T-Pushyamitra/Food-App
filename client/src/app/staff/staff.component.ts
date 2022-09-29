import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StaffService } from '../Services/staff.service';
import { FoodOrder } from './foodOrder';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css'],
})
export class StaffComponent implements OnInit {
  id: any;
  constructor(private service: StaffService) {}
  
  results: any;
  currentOrderId:number | undefined;
  foodOrder: FoodOrder = new FoodOrder('', 0, '', '', 0, false);
  foodItems: any[] = [{ item: '', quantity: '' }];

  ngOnInit(): void {}

  removeItem(i: any) {
    this.foodItems.splice(i, 1);
  }

  addItem() {
    // console.log(this.foodItems)
    this.foodItems.push({ item: '', quantity: '' });
  }

  getTotalPrice() {
    return 100;
  }
  createFoodOrder(order: any){
    this.foodOrder.customerName = order.customerName;
    this.foodOrder.customerNumber = order.customerNumber;
    this.foodOrder.orderCreatedTime = "2022-09-29 10:50";
    // this.foodOrder.orderCreatedTime = new Date().getTime();
    this.foodOrder.totalPrice = this.getTotalPrice();
    this.foodOrder.status = false;
  }

  foodOrders(order: NgForm) {
    this.foodOrder.customerName = order.value.customerName;
    this.foodOrder.customerNumber = order.value.customerNumber;
    this.foodOrder.orderCreatedTime = "2022-09-29 10:50";
    // this.foodOrder.orderCreatedTime = new Date().getTime();
    this.foodOrder.totalPrice = this.getTotalPrice();
    this.foodOrder.status = false;
    this.service.addNewOrder(this.foodOrder).subscribe((data) => {
      this.results = data;
      // this.id = this.results.data.id;
      // this.currentOrderId = this.id;
      console.log(this.foodItems);
      console.log(this.results.data.id)
    });

    this.service.addOrderItems(this.foodItems).subscribe((data) =>{
      console.log(data)
    });

  }
}
