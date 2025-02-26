class bus{
    make:String;
    model:String;
    year:number;
    constructor(make:String,model:String,year:number){
        this.make=make;
        this.model=model;
        this.year=year;
    }
    display(){
        console.log("Bus make:",this.make);
        console.log("Bus model:",this.model);
        console.log("Made in:",this.year);
    }
    start(){
        console.log("Bus is starting");
    }
}
var i:bus=new bus("Volvo","X800",2004);
i.display();
i.start();