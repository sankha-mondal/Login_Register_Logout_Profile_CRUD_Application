import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  constructor(private router: Router,
              private titleService: Title) {
                  this.titleService.setTitle("Admin-Home");
  }

  ngOnInit(): void {
  }

  admin_get_user(): void {
    this.router.navigate(["admin/get_user"], { skipLocationChange: true });
  }

  admin_goto_email_page(): void {
    this.router.navigate(["admin/send_email"], { skipLocationChange: true });
  }
}
