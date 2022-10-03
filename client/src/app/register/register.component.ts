import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name : string = "";
  email : string = "";
  password : string = "";
  role : string = "";
  result : any;
  
  constructor(private service:UserService) { }

  ngOnInit(): void {
  }

  addUser(employeeForm:NgForm){
    console.log(employeeForm.value);
    const employee = employeeForm.value;
    this.service.addEmployee(employee).subscribe((res)=>{
        this.result = res;
        console.log(this.result);
    })
  }

}
