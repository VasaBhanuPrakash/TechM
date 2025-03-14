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
var Shape = /** @class */ (function () {
    function Shape(color) {
        this.color = color;
    }
    Shape.prototype.draw = function () {
        console.log("Shape is drawn");
    };
    return Shape;
}());
var circle = /** @class */ (function (_super) {
    __extends(circle, _super);
    function circle(color) {
        return _super.call(this, color) || this;
    }
    circle.prototype.draw = function () {
        console.log("Circle is drawn");
        console.log(this.color);
    };
    return circle;
}(Shape));
var c = new circle("Red");
c.draw();
