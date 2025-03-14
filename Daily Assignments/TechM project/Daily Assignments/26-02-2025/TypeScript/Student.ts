class Student{
    name:String;
    c:number;
    constructor(name:String,c:number){
        this.name=name;
        this.c=c;
    }
    display(){
        console.log("Student name:",this.name);
        console.log("Class is:",this.c);
    }
}
var s:Student=new Student("Bhsnu",7);
s.display();