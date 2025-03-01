import { Component, OnInit } from '@angular/core';
import { ElectricPipe } from './Electric.pipe';
@Component({
  selector: 'app-custpipe',
  templateUrl: './custpipe.component.html',
  styleUrls: ['./custpipe.component.css'],
  providers:[ElectricPipe]
})
export class CustpipeComponent implements OnInit {
  userName:string="";
  MeterNo:number=0;
  value: number = 0;
  type: string = "Home";  
  constructor(private e:ElectricPipe) { }
  details(){
    var bill=this.e.transform(this.value,this.type);
    alert(`Consumer Name: ${this.userName}\nMeter No: ${this.MeterNo}\nEnergy Consumed:${this.value}\nType: ${this.type}\nElectric Bill:${bill}`);
  }
  ngOnInit(): void {
  }
}
