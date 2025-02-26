var Student = /** @class */ (function () {
    function Student(name, rno) {
        this.name = name;
        this.rno = rno !== null && rno !== void 0 ? rno : -1;
    }
    Student.prototype.display = function () {
        console.log("Student name:", this.name);
        console.log("Class is:", this.rno == -1 ? "Unknown" : this.rno);
    };
    return Student;
}());
var s = new Student("Bhsnu", 7);
s.display();
