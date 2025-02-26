class Person{
    name:String;
    age:Number;
    constructor(name:String,age:Number){
        this.name=name;
        this.age=age;
    }
    display(){
        console.log("Name is:",this.name);
        console.log("Age is:",this.age);
    }
}
class Employee extends Person{
    id:Number;
    constructor(id:Number,name:String,age:Number){
        super(name,age);
        this.id=id;
    }
    display(){
        console.log("Employee id:",this.id);
    }
}
let e:Employee=new Employee(5,"Bhanu",20);
e.display();