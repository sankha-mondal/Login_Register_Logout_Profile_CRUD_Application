import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Pages/home/home.component';
import { AboutUsComponent } from './Pages/about-us/about-us.component';
import { ErrorComponent } from './Pages/error/error.component';
import { LoginComponent } from './Pages/login/login.component';
import { RegisterComponent } from './Pages/register/register.component';
import { UserHomeComponent } from './Pages/User-Only/user-home/user-home.component';
import { ProfileComponent } from './Pages/profile/profile.component';
import { AdminHomeComponent } from './Pages/Admin-Only/admin-home/admin-home.component';
import { AllUserComponent } from './Pages/Admin-Only/all-user/all-user.component';
import { EmailComponent } from './Pages/Admin-Only/email/email.component';

const routes: Routes = [
  { path:'', component: HomeComponent},
  { path:'about_us', component: AboutUsComponent},
  { path:'login', component: LoginComponent},
  { path:'register', component: RegisterComponent},
  { path:'profile', component: ProfileComponent},
  { path:'user/home/:uEmail', component: UserHomeComponent},
  { path:'admin/home', component: AdminHomeComponent},
  { path:'admin/get_user', component: AllUserComponent},
  { path:'admin/send_email', component: EmailComponent},
  { path:'**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
