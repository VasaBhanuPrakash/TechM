import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {
  signupForm: FormGroup;

  constructor(private fb: FormBuilder) {
    // ✅ Initialize form using FormBuilder
    this.signupForm = this.fb.group({
      userName: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dob: [''], // Optional field
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  registerUser() {
    if (this.signupForm.valid) {
      alert(`User Registered Successfully!\n
        User Name: ${this.signupForm.value.userName}\n
        Email: ${this.signupForm.value.email}\n
        Date of Birth: ${this.signupForm.value.dob}
      `);

      // Reset form and refresh page after submission
      setTimeout(() => {
        this.signupForm.reset();
        window.location.reload();
      }, 500);
    } else {
      alert("Please fill all required fields correctly!");
    }
  }

  ngOnInit(): void {}
}
