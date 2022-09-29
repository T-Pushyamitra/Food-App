import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { StaffService } from '../Services/staff.service';

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  constructor(private items:StaffService) { }

  ngOnInit(): void {
  }
  foodOrder(form:NgForm){
    console.log(form.value)
    this.items.addOrder(form.value).subscribe((data)=>{
      console.log(data)
    })


  }

}
