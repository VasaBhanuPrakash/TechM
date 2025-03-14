import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  activeSection: string = 'overview';

  constructor(private router: Router) {}

  showSection(section: string) {
    this.activeSection = section;
  }
  navigateToSection(section: string) {
    this.router.navigate([`/admin-dashboard/${section}`]);
  }

  logout() {
    localStorage.removeItem('adminId');
    this.router.navigate(['/admin-login']);
  }
}
