import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  transactions: number[] = [];
  userId: string = '';
  password: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getUserCredentials();
    this.getTransactions();
  }

  getUserCredentials(): void {
    const storedUser = localStorage.getItem('Banking');
    if (storedUser) {
      const user = JSON.parse(storedUser);
      this.userId = user.username;
      this.password = user.password;
    } else {
      console.error('User credentials not found');
    }
  }

  getTransactions(): void {
    if (this.userId && this.password) {
      this.http.get<number[]>(`http://localhost:8400/api/banking/login/${this.userId}/${this.password}/trans`)
        .subscribe({
          next: (data) => {
            console.log('Fetched transactions:', data);
            this.transactions = data;
          },
          error: (error) => {
            console.error('Error fetching transactions', error);
          }
        });
    }
  }
}
