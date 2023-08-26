import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Pages/home/home.component';
import { NavbarComponent } from './Parts/navbar/navbar.component';
import { FooterComponent } from './Parts/footer/footer.component';
import { AboutUsComponent } from './Pages/about-us/about-us.component';
import { ErrorComponent } from './Pages/error/error.component';
import { LoginComponent } from './Pages/login/login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserHomeComponent } from './Pages/User-Only/user-home/user-home.component';
import { ProfileComponent } from './Pages/profile/profile.component';
import { AdminHomeComponent } from './Pages/Admin-Only/admin-home/admin-home.component';
import { AllUserComponent } from './Pages/Admin-Only/all-user/all-user.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { EmailComponent } from './Pages/Admin-Only/email/email.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    AboutUsComponent,
    ErrorComponent,
    LoginComponent,
    RegisterComponent,
    UserHomeComponent,
    ProfileComponent,
    AdminHomeComponent,
    AllUserComponent,
    EmailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule, HttpClientModule,
    Ng2SearchPipeModule, BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
