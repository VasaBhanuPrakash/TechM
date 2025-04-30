import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private apiUrl = 'http://localhost:8080/api/v1/cart';

  constructor(private http: HttpClient) { }

  getCart(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  addToCart(productId: number, quantity: number): Observable<any> {
    const params = new HttpParams()
      .set('productId', productId.toString())
      .set('quantity', quantity.toString());

    return this.http.post<any>(`${this.apiUrl}/add`, null, { params });
  }

  removeFromCart(productId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/remove/${productId}`);
  }

  clearCart(): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/clear`);
  }
}
