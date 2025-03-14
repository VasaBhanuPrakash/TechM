var color;
(function (color) {
    color["red"] = "red";
    color["green"] = "green";
    color["blue"] = "blue";
    color["white"] = "white";
})(color || (color = {}));
var scolor = color.blue;
console.log(scolor);
