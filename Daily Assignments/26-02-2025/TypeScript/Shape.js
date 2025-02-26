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
    return Shape;
}());
var circle = /** @class */ (function (_super) {
    __extends(circle, _super);
    function circle(color, r) {
        var _this = _super.call(this, color) || this;
        _this.r = r;
        return _this;
    }
    circle.prototype.display = function () {
        console.log("Color is:", this.color);
        console.log("Radius is:", this.r);
    };
    return circle;
}(Shape));
var s = new circle("red", 5);
s.display();
