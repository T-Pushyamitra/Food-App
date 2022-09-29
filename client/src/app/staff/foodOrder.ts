export class FoodOrder {
  customerName: any;
  customerNumber: any;
  orderCreatedTime: any;
  totalPrice: any;
  status: boolean | undefined;
  orderDeliveryTime: any;

  constructor(
    customerName: string,
    contactNumber: number,
    orderCreatedTime: string,
    orderDeliveryTime: string,
    totalPrice: number,
    status: boolean
  ) {}
}
