import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SupportService {
  private baseUrl = 'http://localhost:8400/api/banking/support';

  constructor(private http: HttpClient) {}

  submitQuery(userId: string, subject: string, message: string): Observable<string> {
    return this.http.post<string>(`${this.baseUrl}/submit`, { userId, subject, message });
  }
}
