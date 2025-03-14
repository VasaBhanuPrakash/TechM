let x:string="let";
var y:string="var";
const z:string="const";
console.log(x);
console.log(y);
console.log(z);
try{
    let x:string="Let";
    console.log(x);
}
catch(error){
    console.log("Error Occured:",error.message);
}
try{
    var y:string="var";
    var y:string="Var";
    console.log(y);
}
catch(e){
    console.log("Error Occured:",e);
}
try{
    const z:string="const";
    console.log(z);
}
catch(e){
    console.log("Error Occured:",e);
}
try{
    x="Let assign";
    console.log(x);
}
catch(e){
    console.log("Error Occured:",e);
    
}
try{
    y="Var assign";
    console.log(y);
}
catch(e){
    console.log("Error Occured:",e);
}
try{
    const z="const assign";
    console.log(z);
}
catch(e){
    console.log("Error Occured:",e);
}