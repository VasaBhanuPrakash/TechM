class Engine {
    hp: number;
    ftype: string;
}

class Car extends Engine {
    make: string;
    model: string;
    year: number;

    start() {
        console.log("Car starts");
    }

    display() {
        console.log("Made by:", this.make);
        console.log("Model is:", this.model);
        console.log("Made on:", this.year);
        console.log("HorsePower:", this.hp);
        console.log("Fuel Type:", this.ftype);
    }
}
var c = new Car();
c.make = "Tata";
c.model = "Safari";
c.year = 2023;
c.hp = 240;
c.ftype = "Diesel";

c.start();
c.display();
