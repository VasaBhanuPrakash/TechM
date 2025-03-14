class Animal{
    name:String;
    species:String;
    constructor(name:String,species:String){
        this.name=name;
        this.species=species;
    }
    display(){
        console.log("Name of Animal is:",this.name);
        console.log("Species name:",this.species);
    }
}
class Tiger extends Animal{
    constructor(name:String){
        super(name,"Tiger");
    }
    roar(){
        console.log("Tiger is roaring");
    }
}
var t:Tiger=new Tiger("Sher");
t.display();
t.roar();
