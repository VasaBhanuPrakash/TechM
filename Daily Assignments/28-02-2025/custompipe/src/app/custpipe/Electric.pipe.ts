import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: "ElectricBill"
})
export class ElectricPipe implements PipeTransform {
    transform(value: number, type: string): number {
        let bill: number;

        if (type === "Home") {
            if (value < 50) {
                bill = (1.95 * value);
            } else if (value < 100) {
                bill = 97.5 + ((value - 50) * 3.1);
            } else if (value < 150) {
                bill = 252.5 + ((value - 100) * 5.6);
            } else if (value < 200) {
                bill = 532 + ((value - 150) * 10.25);
            } else {
                bill = 1044.5 + ((value - 200) * 18.75);
            }
        } else {
            if (value < 100) {
                bill = value * 8.5;
            } else if (value < 300) {
                bill = 850 + ((value - 100) * 9.9);
            } else if (value < 500) {
                bill = 2830 + ((value - 300) * 10.4);
            } else {
                bill = 4870 + ((value - 500) * 11);
            }
        }
        if(bill<70){
            return 70;
        }
        else{
            return bill;
        }
    }
}
