import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BranchService } from '../Services/branch.service';
import { FoodProductService } from '../Services/food-product.service';
import { MenuService } from '../Services/menu.service';

@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css'],
})
export class BranchComponent implements OnInit {
  results: any;
  error: any;
  errorMessage: any;
  // availabilty : boolean = true
  _userId = localStorage.getItem("id");
  _isMenu: boolean = false;
  _menuId : any = 6;
  _type: string = "";
  foodProducts: any;
  foodProduct: any[] = [];
  types = ['Veg', 'Non-Veg', 'Drinks'];

  constructor(
    private branch: BranchService,
    private menuService: MenuService,
    private foodProductService: FoodProductService,
    private router: Router) {}

  ngOnInit(): void {
    this.foodProductService
    .getFoodProductsByMenuId(this._menuId)
    .subscribe((response) => {
      this.foodProducts = response;
      console.log(this.foodProducts);
    });
  }

  // Create Menu
  createMenu(): void {
    this.menuService.createMenu(this._userId).subscribe((response) => {
      console.log('Menu data :' + response.valueOf);
    });
  }

  // Get All Food Products by menu id
  getFoodProductsByMenuId() {
    this.foodProductService
      .getFoodProductsByMenuId(this._menuId)
      .subscribe((response) => {
        this.foodProducts = response;
        console.log(this.foodProducts);
      });
  }

  addFoodProduct(foodProdut: NgForm): any {
    // Set Availability
    foodProdut.value.availability = true;
    console.log(foodProdut.value);
    // List[foodProduct]
    this.foodProduct.push(foodProdut.value);

    this.foodProductService
      .addFoodproductsByMenuid(this.foodProduct, this._menuId)
      .subscribe((response) => {
        this.error = response
        if(this.error.data == null){
          this.errorMessage = "Added Successfully"
        }
        console.log(response);
        this.router.navigate(['/menu',this._userId]);
        this.foodProductService.getFoodProductsByMenuId(this._menuId).subscribe(
          (data) => {
            this.foodProducts = data;
          },
        );
      });
  }

  // Delete Product by id

  deleteFoodProduct(id: any) {
    console.log(id);
    this.foodProductService.deleteFoodproductById(id).subscribe((response) => {
      console.log(response);
      this.router.navigate(['/menu',this._userId]);
      this.foodProductService.getFoodProductsByMenuId(this._menuId).subscribe(
        (data) => {
          this.foodProducts = data;
        },
      );
    });
    
  }

  // this.branch.deleteFoodProduct(id).subscribe((res) => {
  //   console.log(res);
  //   this.router.navigate(['/menu']);
  //   this.branch.getMenu(1).subscribe((data) => {
  //     this.results = data;
  //   });
  // });



  productId(id: any) {
    return id;
  }

  updateFoodProduct(updateFoodProduct: NgForm): any {
    console.log(updateFoodProduct);
  }

  check(id:any){

  }
}
