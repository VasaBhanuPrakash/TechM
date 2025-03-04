import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {BookTicketComponent} from './book-ticket/book-ticket.component';
import {BookingListComponent} from './booking-list/booking-list.component';
import {FooterComponent} from './footer/footer.component';
import {HeaderComponent} from './header/header.component';
import {TDetailsComponent} from './t-details/t-details.component';
import {UpdateBookingComponent} from './update-booking/update-booking.component';
const routes: Routes = [
  {path:'',redirectTo:'booking',pathMatch:'full'},
  {path:'bookings',component:BookTicketComponent},
  { path: 'update/:id', component: UpdateBookingComponent },
  { path: 'details/:id', component: TDetailsComponent },
  { path: 'about', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
