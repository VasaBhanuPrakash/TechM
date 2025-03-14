var Student = /** @class */ (function () {
    function Student(name, c) {
        this.name = name;
        this.c = c;
    }
    Student.prototype.display = function () {
        console.log("Student name:", this.name);
        console.log("Class is:", this.c);
    };
    return Student;
}());
var s = new Student("Bhsnu", 7);
s.display();
