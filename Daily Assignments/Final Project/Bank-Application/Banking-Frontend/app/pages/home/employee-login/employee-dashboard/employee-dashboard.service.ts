import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDashboardService {
  private apiUrl = 'http://localhost:8400/api/banking';

  constructor(private http: HttpClient) {}

  getLoanApplications(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/loans`);
  }


  approveLoan(loanId: number, status: boolean): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/loan/${loanId}/approve/${status}`, {}).pipe(
      //tap(() => console.log(`Loan ${loanId} ${status ? 'approved' : 'rejected'}`)),
      catchError(error => {
        console.error(`Error updating loan ${loanId}`, error);
        return throwError(error);
      })
    );
  }

  getAllUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/users`).pipe(
      catchError(error => {
        console.error('Error fetching users', error);
        return throwError(error);
      })
    );
  }

  getFeedbacks(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/feedbacks`).pipe(
      catchError(error => {
        console.error('Error fetching feedbacks', error);
        return throwError(error);
      })
    );
  }

  getFinancialReports(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/reports`).pipe(
      catchError(error => {
        console.error('Error fetching financial reports', error);
        return throwError(error);
      })
    );
  }

  getUserTransactionHistory(userId: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/users/${userId}/transactions`).pipe(
      catchError(error => {
        console.error('Error fetching transaction history', error);
        return throwError(error);
      })
    );
  }

  getPendingApprovals(): Observable<string[]> {
    return this.http.get<string[]>(`${this.apiUrl}/approvals`).pipe(
      catchError(error => {
        console.error('Error fetching pending approvals', error);
        return throwError(error);
      })
    );
  }
}
