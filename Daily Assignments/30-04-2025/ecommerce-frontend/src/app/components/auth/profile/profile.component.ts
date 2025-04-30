import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  profile: any;
  user: any = null;

  constructor(private authService: AuthService) {
    this.loadProfile();
  }

  loadProfile() {
    this.authService.getProfile().subscribe({
      next: (data: any) => {
        this.user = data;
        console.log('User profile data:', this.user);
      },
      error: (err: any) => {
        console.error('Error fetching profile', err);
      }
    });
  }
}
