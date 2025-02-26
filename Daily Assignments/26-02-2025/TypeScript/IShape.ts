class Shape{
    color:String;
    constructor(color:String){
        this.color=color;
    }
    draw(){
        console.log("Shape is drawn");
    }
}
class circle extends Shape{
    constructor(color:String){
        super(color);
    }
    draw(){
        console.log("Circle is drawn");
        console.log(this.color);
    }
}
var c:circle=new circle("Red");
c.draw();