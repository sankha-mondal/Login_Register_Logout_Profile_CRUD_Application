import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router,
              private titleService: Title) {
                  this.titleService.setTitle("Home Page");
  }

  ngOnInit(): void {
    
  }

  goto_login_page(): void {
    this.router.navigate(["login"], { skipLocationChange: true });
  }

}
