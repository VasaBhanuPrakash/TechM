import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Import components for routing
import { CartComponent } from './components/cart/cart.component';
import { ProfileComponent } from './components/auth/profile/profile.component';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { OrderHistoryComponent } from './components/order/order-history/order-history.component';
import { OrderDetailsComponent } from './components/order/order-details/order-details.component';

const routes: Routes = [
  { path: 'cart', component: CartComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'order-history', component: OrderHistoryComponent },
  { path: 'order-details/:id', component: OrderDetailsComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }  // Default route to login
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
