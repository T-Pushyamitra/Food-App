import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status'
})
export class StatusPipe implements PipeTransform {

  transform(foodOrders:any[],status:any): any {
    if(status == ""){
      return foodOrders;
    }
    return foodOrders.filter(order => order.status === status);
  }

}
