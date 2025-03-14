var Student = /** @class */ (function () {
    function Student(name, age) {
        this.name = name;
        this.age = age;
    }
    Student.prototype.display = function () {
        console.log("Student name:", this.name);
        console.log("Class is:", this.age > 0 ? this.age : 0);
    };
    return Student;
}());
var s = new Student("Bhsnu", 7);
s.display();
var s = new Student("Bhsnu", -7);
s.display();
