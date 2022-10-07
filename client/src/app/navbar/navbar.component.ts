import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  role:string|null = "";
  id :any;
  
  constructor(private router:Router) { }
  
  ngOnInit(): void {
    this.role = localStorage.getItem("role");
    this.id = localStorage.getItem("id");
  }

  logout(){
    localStorage.clear()
    this.router.navigate(["login"])
  }
}
