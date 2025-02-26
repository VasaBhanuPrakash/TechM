class Car {
    name: string;
    madeBy: string;
    year: number;
}
class SUV extends Car{
    suv:boolean;
    display(): void {
        console.log("car name:",this.name);
        console.log("Manufactured by:",this.madeBy);
        console.log("Made on:",this.year);
        if(this.suv){
            console.log("Car is suitable for off-road driving");
        }
        else{
            console.log("Car is not suitable for off-road driving");
        }
    }
} 
let c: SUV=new SUV();
c.name = "Safari";
c.madeBy = "Tata";
c.year = 2003;
c.suv=true;
c.display();
