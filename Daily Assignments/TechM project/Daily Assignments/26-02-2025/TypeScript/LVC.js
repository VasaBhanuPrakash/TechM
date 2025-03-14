var x = "let";
var y = "var";
var z = "const";
console.log(x);
console.log(y);
console.log(z);
try {
    var x_1 = "Let";
    console.log(x_1);
}
catch (error) {
    console.log("Error Occured:", error.message);
}
try {
    var y = "var";
    var y = "Var";
    console.log(y);
}
catch (e) {
    console.log("Error Occured:", e);
}
try {
    var z_1 = "const";
    console.log(z_1);
}
catch (e) {
    console.log("Error Occured:", e);
}
try {
    x = "Let assign";
    console.log(x);
}
catch (e) {
    console.log("Error Occured:", e);
}
try {
    y = "Var assign";
    console.log(y);
}
catch (e) {
    console.log("Error Occured:", e);
}
try {
    var z_2 = "const assign";
    console.log(z_2);
}
catch (e) {
    console.log("Error Occured:", e);
}
