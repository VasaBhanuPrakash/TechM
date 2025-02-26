class Student{
    name:String;
    rno:number;
    constructor(name:String,rno?:number){
        this.name=name;
        this.rno=rno??-1;
    }
    display(){
        console.log("Student name:",this.name);
        console.log("Class is:",this.rno==-1?"Unknown":this.rno);
    }
}
var s:Student=new Student("Bhsnu",7);
s.display();