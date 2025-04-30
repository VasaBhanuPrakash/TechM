import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  user = {
    username: '',
    email: '',
    password: '',
    role: 'USER'
  };

  constructor(private http: HttpClient, private router: Router) {}

  async register() {
    try {
      const response: any = await this.http.post('http://localhost:8080/api/v1/auth/register', this.user).toPromise();

      alert('User registered successfully!');
      this.router.navigate(['/login']);
    } catch (error) {
      alert('Registration failed. Please try again.');
      console.error('Error:', error);
    }
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
