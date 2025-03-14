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
var Car = /** @class */ (function () {
    function Car() {
    }
    return Car;
}());
var SUV = /** @class */ (function (_super) {
    __extends(SUV, _super);
    function SUV() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    SUV.prototype.display = function () {
        console.log("car name:", this.name);
        console.log("Manufactured by:", this.madeBy);
        console.log("Made on:", this.year);
        if (this.suv) {
            console.log("Car is suitable for off-road driving");
        }
        else {
            console.log("Car is not suitable for off-road driving");
        }
    };
    return SUV;
}(Car));
var c = new SUV();
c.name = "Safari";
c.madeBy = "Tata";
c.year = 2003;
c.suv = true;
c.display();
