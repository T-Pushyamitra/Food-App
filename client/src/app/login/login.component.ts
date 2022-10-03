import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email: string = "";
  password: string = "";
  employee: any;
  id: any;
  invalidLogin: boolean | undefined;

  constructor(private service:UserService) { }

  ngOnInit(): void {
  }


  doLogin(employee:NgForm){
    console.log(employee.value)
   this.service.getUserByEmail(employee.value.email).subscribe((user) => {  
    console.log(user);
  })
  }
}
