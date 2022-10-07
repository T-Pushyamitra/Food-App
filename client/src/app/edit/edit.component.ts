import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodProductService } from '../Services/food-product.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  result: any;
  selectedProduct: any;
  id:any;
  menuId: any;
  constructor( private activatedRoute: ActivatedRoute,private foodProduct:FoodProductService,private router:Router) { }
  
  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['productid'];
    this.menuId = this.activatedRoute.snapshot.params['menuid'];
    console.log(this.id)
    this.foodProduct.getFoodProductsByMenuId(9).subscribe((data)=>{
      this.result = data;
      for (let item of this.result.data) {
        console.log(item.id == this.id)
        if (item.id == this.id) {
          this.selectedProduct = item;
          console.log(this.selectedProduct)
        }
        else{
          
        }
      }
    })
  }

  updateFoodproduct(form:NgForm){
    console.log(form.value)
    this.foodProduct.updateFoodProduct(form.value,this.menuId,this.id).subscribe((response)=>{
      console.log(response);
      this.router.navigate(["/menu",localStorage.getItem("id")])
    })
}

}
