import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'totalPrice'
})
export class TotalPricePipe implements PipeTransform {

  transform(value:any[]): any{
    var sum = 0;
    value.forEach(function (price : any){
      sum + price.price;
    })
    console.log(sum)
    return sum;
  }

}
