import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';

@Component({
  selector: 'app-about-us',
  templateUrl: './about-us.component.html',
  styleUrls: ['./about-us.component.css']
})
export class AboutUsComponent implements OnInit {

  constructor(private router: Router,
              private titleService: Title) {
                    this.titleService.setTitle("About Us");
  }

  ngOnInit() {
  }

  goto_register_page(): void {
    this.router.navigate(["/register"], { skipLocationChange: true });
  }


}

