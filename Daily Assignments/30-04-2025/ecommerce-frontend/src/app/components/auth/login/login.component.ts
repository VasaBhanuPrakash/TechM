import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  user = {
    username: '',
    password: ''
  };
  otp: string = '';
  showOtpField: boolean = false;

  constructor(private http: HttpClient, private router: Router) {}

  async login() {
    try {
      const response: any = await this.http.post(
        'http://localhost:8080/api/v1/auth/login',
        this.user
      ).toPromise();

      if (response && response.token) {
        alert('OTP has been sent to your registered email.');
        this.showOtpField = true;
        localStorage.setItem('AuthToken', response.token);
      } else {
        alert('Error: Invalid Username or Password');
      }
    } catch (error) {
      alert('Login Failed. Check your credentials.');
      console.error('Error:', error);
    }
  }

  async verifyOtp() {
    try {
      const token = localStorage.getItem('AuthToken');
      const response: any = await this.http.post(
        `http://localhost:8080/api/v1/auth/verify-otp`,
        { username: this.user.username, otp: this.otp },
        { headers: { Authorization: `Bearer ${token}` } }
      ).toPromise();

      if (response && response.success) {
        localStorage.setItem('Username', this.user.username);
        this.router.navigate(['/profile']);
      } else {
        alert('Invalid OTP. Please try again.');
      }
    } catch (error) {
      alert('Invalid OTP. Please try again.');
      console.error('Error:', error);
    }
  }

  navigateToRegister() {
    this.router.navigate(['/register']);
  }
}
