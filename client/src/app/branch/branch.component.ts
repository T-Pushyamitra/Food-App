import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { BranchService } from '../Services/branch.service';

@Component({
  selector: 'app-branch',
  templateUrl: './branch.component.html',
  styleUrls: ['./branch.component.css']
})
export class BranchComponent implements OnInit {
  results: any;
  error : any;
  errorMessage : any;
  userId : number = 14;
  

  constructor(private branch:BranchService, private router:Router) { }

  ngOnInit(): void {
    this.getMenu()
  }


  getMenu(){
    this.branch.getMenu(this.userId).subscribe((data) =>{
      this.results = data;

      console.log(this.results);
  },(err) => {
    this.error = err;
    this.errorMessage = err.message;
    console.log(this.errorMessage);
    console.log(this.error);
  });
  }


  productId(id:any){
    return id;
  }

  addFoodProduct(newFoodProduct : NgForm): any{
    newFoodProduct.value.availability = true
    this.branch.addFoodProduct(newFoodProduct.value,this.userId).subscribe((res) => {
      console.log(res);
      this.router.navigate(['/menu']);
      this.branch.getMenu(1).subscribe((data) => {
        this.results = data;
      });
    })
  }

  // updateFoodProduct(updateFoodProduct : NgForm): any{


  deleteFoodProduct(id:any){
    console.log(id)
    this.branch.deleteFoodProduct(id).subscribe((res) =>{
      console.log(res);
      this.router.navigate(['/menu']);
      this.branch.getMenu(1).subscribe(
        (data) => {
          this.results = data;
        },
      );
    })
  }

}
