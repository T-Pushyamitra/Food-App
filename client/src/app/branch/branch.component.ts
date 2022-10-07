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

  /**
   *  login -> id and role
   *  id -> menu_id
   * menu_id -> food products
   *  */

  // => id = 30
  // => menuid = 9

  results: any;
  error: any;
  errorMessage: any;
  // availabilty : boolean = true
  _userId = localStorage.getItem('id');
  _isMenu: boolean = false;
  _menuId: any;
  _type: string = '';
  foodProducts: any;
  foodProduct: any;
  addNewProduct: any[] = [];
  types = ['Veg', 'Non-Veg', 'Drinks'];
  pattern = ""
  constructor(
    private branch: BranchService,
    private menuService: MenuService,
    private foodProductService: FoodProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
      this.foodProducts = response;
      this.foodProduct = this.foodProducts.data.foodProducts;
      this._menuId = this.foodProducts.data.id;
      console.log(this._menuId);
    });
  }

  // Retrive branch Manager specific menu id
  getFoodProducts() {
    this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
      this.foodProducts = response;
    });
    console.log(this.foodProducts);
    return this.foodProducts; // {menu and products}
  }

  // Create Menu
  createMenu(): void {
    console.log(this._userId);
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
    this.addNewProduct.push(foodProdut.value);

    this.foodProductService
      .addFoodproductsByMenuid(this.addNewProduct, this._menuId)
      .subscribe((response) => {
        this.error = response;
        if (this.error.data == null) {
          this.errorMessage = 'Added Successfully';
        }
        console.log(response);
        this.router.navigate(['/menu', this._userId]);
        this.menuService.getMenuByUserId(this._userId).subscribe((response) => {
          this.foodProducts = response;
          this.foodProduct = this.foodProducts.data.foodProducts;
          this._menuId = this.foodProducts.data.id;
          console.log(this._menuId);
        });
      });
  }

  // Delete Product by id

  deleteFoodProduct(id: any) {
    console.log(id);
    this.foodProductService.deleteFoodproductById(id).subscribe((response) => {
      console.log(response);
      this.router.navigate(['/menu', this._userId]);
      this.menuService.getMenuByUserId(this._userId).subscribe((response)=>{
        this.foodProducts = response;
        this.foodProduct = this.foodProducts.data.foodProducts;
        this._menuId = this.foodProducts.data.id;
        console.log(this._menuId)
      })
    });
  }

 

}
