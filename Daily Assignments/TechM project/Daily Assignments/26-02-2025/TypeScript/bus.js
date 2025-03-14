var bus = /** @class */ (function () {
    function bus(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    bus.prototype.display = function () {
        console.log("Bus make:", this.make);
        console.log("Bus model:", this.model);
        console.log("Made in:", this.year);
    };
    return bus;
}());
var i = new bus("Volvo", "X800", 2004);
i.display();
