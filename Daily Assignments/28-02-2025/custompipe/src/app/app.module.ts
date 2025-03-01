import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';  
import { AppComponent } from './app.component';
import { CustpipeComponent } from './custpipe/custpipe.component';
import { ElectricPipe } from './custpipe/Electric.pipe'; 
@NgModule({
  declarations: [
    AppComponent,
    CustpipeComponent,
    ElectricPipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
