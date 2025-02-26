var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Engine = /** @class */ (function () {
    function Engine() {
    }
    return Engine;
}());
var Car = /** @class */ (function (_super) {
    __extends(Car, _super);
    function Car() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    Car.prototype.start = function () {
        console.log("Car starts");
    };
    Car.prototype.display = function () {
        console.log("Made by:", this.make);
        console.log("Model is:", this.model);
        console.log("Made on:", this.year);
        console.log("HorsePower:", this.hp);
        console.log("Fuel Type:", this.ftype);
    };
    return Car;
}(Engine));
var c = new Car();
c.make = "Tata";
c.model = "Safari";
c.year = 2023;
c.hp = 240;
c.ftype = "Diesel";
c.start();
c.display();
