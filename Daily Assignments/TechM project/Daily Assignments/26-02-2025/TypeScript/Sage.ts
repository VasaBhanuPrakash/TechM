class Student{
    name:String;
    age:number;
    constructor(name:String,age:number){
        this.name=name;
        this.age=age;
    }
    display(){
        console.log("Student name:",this.name);
        console.log("Class is:",this.age>0?this.age:0);
    }
}
var s:Student=new Student("Bhsnu",7);
s.display();
var s:Student=new Student("Bhsnu",-7);
s.display();