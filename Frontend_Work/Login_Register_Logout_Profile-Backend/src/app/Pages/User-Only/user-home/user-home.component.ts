import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Subscription, map, share, timer } from 'rxjs';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private titleService: Title) {
                  this.titleService.setTitle("Passenger Home");
              }

  welcome_name = "";
  time = new Date();
  rxTime = new Date();
  intervalId: any;
  
  subscription: Subscription = new Subscription;

  uName: any;
  bela: any;

// ================================================== Date & Time =============================================================

  ngOnInit() {
    this.welcome_name = this.route.snapshot.params['uEmail'];
    // Using Basic Interval
    this.intervalId = setInterval(() => {
      this.time = new Date();

      let hr = this.time.getHours();
      console.log(hr);

      if (hr >= 3 && hr < 12)
        this.bela = "Morning";
      else if (hr == 12) {
        this.bela = "Noon";
      }
      else if (hr > 12 && hr <= 18)
        this.bela = "Afternoon";
      else
        this.bela = "Evening";
    }, 1000);



// =======================  Using RxJS Timer  ============================
    this.subscription = timer(0, 1000)
      .pipe(
        map(() => new Date()),
        share()
      )
      .subscribe(time => {
        this.rxTime = time;
      });
    this.getName();
  }


  getName() {
    let name = sessionStorage.getItem("name_session");
    this.uName = name;
  }

  ngOnDestroy() {
    clearInterval(this.intervalId);
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

// ===============================================================================================================================

}

