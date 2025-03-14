import { Component, OnInit } from '@angular/core';
import { EmployeeDashboardService } from './employee-dashboard.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {
  activeSection: string = 'users';
  users: any[] = [];
  loans: any[] = [];
  feedbacks: any[] = [];
  approvals: string[] = [];

  constructor(
    private dashboardService: EmployeeDashboardService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const section = params.get('section');
      if (section) {
        this.activeSection = section;
      }
    });

    this.loadUsers();
    this.loadLoans();
    this.loadFeedbacks();
    this.loadApprovals();
  }

  navigateToSection(section: string) {
    this.router.navigate(['/employee-dashboard', section]);
  }

  loadUsers() {
    this.dashboardService.getAllUsers().subscribe({
      next: (data) => (this.users = data),
      error: (err) => console.error('Error loading users:', err)
    });
  }

  loadLoans() {
    this.dashboardService.getLoanApplications().subscribe({
      next: (data) => {
        console.log("Loan Applications:", data); 
        this.loans = data;
      },
      error: (err) => console.error('Error loading loans:', err)
    });
  }

  approveLoan(loan: any) {
    this.dashboardService.approveLoan(loan.id, true).subscribe({
      next: () => {
        console.log(`Loan ${loan.id} approved`);
        loan.status = 'Approved';
        this.loadLoans();
      },
      error: (err) => console.error('Error approving loan:', err)
    });
  }

  rejectLoan(loan: any) {
    this.dashboardService.approveLoan(loan.id, false).subscribe({
      next: () => {
        console.log(`Loan ${loan.id} rejected`);
        loan.status = 'Rejected';
        this.loadLoans();
      },
      error: (err) => console.error('Error rejecting loan:', err)
    });
  }

  loadFeedbacks() {
    this.dashboardService.getFeedbacks().subscribe({
      next: (data) => (this.feedbacks = data),
      error: (err) => console.error('Error loading feedbacks:', err)
    });
  }

  loadApprovals() {
    this.dashboardService.getPendingApprovals().subscribe({
      next: (data) => (this.approvals = data),
      error: (err) => console.error('Error loading approvals:', err)
    });
  }

  respondToFeedback(feedback: any) {
    alert('Responding to: ' + feedback.message);
  }

  logout() {
    localStorage.removeItem('employeeId');
    this.router.navigate(['/employee-login']);
  }

  viewHistory(user: any) {
    this.dashboardService.getUserTransactionHistory(user.username).subscribe({
      next: (history) => console.log('Transaction history:', history),
      error: (err) => console.error('Error fetching transaction history:', err)
    });
  }

  generateReport() {
    alert('Generating Financial Report...');
  }
}
