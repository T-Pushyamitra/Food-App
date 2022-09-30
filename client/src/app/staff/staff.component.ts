import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TotalPricePipe } from '../Pipes/total-price.pipe';
import { MenuService } from '../Services/menu.service';
import { FoodProductService } from '../Services/food-product.service';
import { StaffService } from '../Services/staff.service';
import { FoodOrder } from './foodOrder';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css'],
})
export class StaffComponent implements OnInit {
  foodProductsList: any;
  type: any;
  menuData: any;
  foodOrderData:any;
  foodOrder: FoodOrder = new FoodOrder('', 0, '', '', 0, false);
  foodItems: any[] = [];
  quantity: number = 1;
  orderForm: any;
  i:any= 1;

  constructor(
    private service: StaffService,
    private foodProducts: FoodProductService,
    private menu:MenuService,
    private totalPrice: TotalPricePipe,
  ) { }

  ngOnInit(): void {
    this.menu.getMenu().subscribe((data)=>{
      this.menuData = data;
      console.log(this.menuData.data.foodProducts) ;
    })

  }


plus(){
  if(this.i !=10){
    this.i++;
    this.quantity =this.i;
  }
}
minus(){
  if(this.i !=1){
    this.i--;
    this.quantity =this.i;
  }
}



  addItem(id:any){
      this.foodItems.push(id)
  }

  getTotalPrice() {
    console.log(this.totalPrice.transform(this.foodItems));
    return this.totalPrice.transform(this.foodItems);
  }

  createFoodOrder(order: any) {
    this.foodOrder.customerName = order.customerName;
    this.foodOrder.customerNumber = order.customerNumber;
    this.foodOrder.orderCreatedTime = '2022-09-29 10:50';
    // this.foodOrder.orderCreatedTime = new Date().getTime();
    this.foodOrder.totalPrice = this.getTotalPrice();
    this.foodOrder.status = false;
    return this.foodOrder;
  }


  foodOrders(order: NgForm) {
    console.log(order.value);
    this.service
      .addNewOrder(this.createFoodOrder(order.value))
      .subscribe((data) => {
        this.foodOrderData = data;
        console.log('Order Has been Taken ' + this.foodOrderData.data.id);
      });

    // this.service
    //   .addOrderItems(this.foodItems, this.foodOrderData.data.id)
    //   .subscribe((data) => {
    //     console.log(data);
    //   });
  }
}
