import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { TicketComponent } from './ticket/ticket.component';
import { BookTicketComponent } from './book-ticket/book-ticket.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { TDetailsComponent } from './t-details/t-details.component';
import { UpdateBookingComponent } from './update-booking/update-booking.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TicketComponent,
    BookTicketComponent,
    HeaderComponent,
    FooterComponent,
    BookingListComponent,
    TDetailsComponent,
    UpdateBookingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
