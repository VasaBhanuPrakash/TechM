class Vehicle{
    make:string;
    model:string;
    constructor(make:string,model:string){
        this.make=make;
        this.model=model;
    }
    display(){
        console.log("Car Company:",this.make);
        console.log("Car Model:",this.model);
    }
}
class Car extends Vehicle{
    constructor(make:string,model:string){
        super(make,model);
    }
}
class SportsCar extends Car{
    constructor(make:string,model:string){
        super(make,model);
    }
}
var s:SportsCar=new SportsCar("Ferrari","F8");
s.display();