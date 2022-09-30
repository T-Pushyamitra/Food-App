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
  _type: string = '';
  menuData: any;
  foodOrderData: any;
  quantity: number | undefined;
  _isOrderTaken = false;
  foodItems: any[] = [];
  foodOrder: FoodOrder = new FoodOrder('', 0, '', '', 0, false);
  types = ['Veg', 'Non-Veg', 'Drinks'];

  constructor(
    private service: StaffService,
    private menu: MenuService,
    private totalPrice: TotalPricePipe
  ) {}

  ngOnInit(): void {
    this.menu.getMenu().subscribe((data) => {
      this.menuData = data;
      this.menuData = this.menuData.data;
      console.log(this.menuData);
    });
  }

  plus(id: any) {
    this.foodItems[id].quantity += 1;
  }
  minus(id: any) {
    if (this.foodItems[id].quantity < 2) {
      this.foodItems.splice(id, 1);
    }
    this.foodItems[id].quantity -= 1;
  }

  addItem(id: any) {
    this.menuData.foodProducts.filter((item: any) => {
      if (item.id === id) {
        this.foodItems.push({
          name: item.name,
          price: item.price,
          quantity: 1,
          type: item.type,
        });
      }
    });
  }

  getTotalPrice() {
    return this.totalPrice.transform(this.foodItems);
  }

  createFoodOrder(order: any) {
    this.foodOrder.customerName = order.customerName;
    this.foodOrder.customerNumber = parseInt(order.customerNumber);
    return this.foodOrder;
  }

  updateFoodOrder() {
    this.foodOrder.orderCreatedTime = '2022-09-29 10:50';
    this.foodOrder.totalPrice = this.totalPrice.transform(this.foodItems);

    this.service
      .updateFoodOrder(this.foodOrder, this.foodOrderData.data.id)
      .subscribe((res) => {
        console.log(res);
      });
  }

  foodOrders(order: NgForm) {
    this._isOrderTaken = !this._isOrderTaken;
    console.log(order.value);
    this.service
      .addNewOrder(this.createFoodOrder(order.value))
      .subscribe((data) => {
        this.foodOrderData = data;
        console.log('Order Has been Taken ' + this.foodOrderData.data.id);
        // console.log('Name ' +  this.foodOrderData.data.name);
      });
  }
  postOrder() {
    // this.foodOrder.orderCreatedTime = '2022-09-29 10:50';
    // this.foodOrder.totalPrice = this.totalPrice.transform(this.foodItems);
    this.service
      .addOrderItems(this.foodItems, this.foodOrderData.data.id)
      .subscribe((data) => {
        console.log(data);
      });
    this.updateFoodOrder();
  }
}
