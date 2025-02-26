class Shape{
    color:string;
    constructor(color:string){
        this.color=color;
    }
}
class circle extends Shape{
    r:number;
    constructor(color:string,r:number){
        super(color);
        this.r=r;
    }
    display(){
        console.log("Color is:",this.color);
        console.log("Radius is:",this.r);
    }
}
var s:circle=new circle("red",5);
s.display();