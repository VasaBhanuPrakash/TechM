import { Component } from '@angular/core';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  cart: any = null;

  constructor(private cartService: CartService) {
    this.getCart();
  }

  getCart() {
    this.cartService.getCart().subscribe({
      next: (data) => {
        this.cart = data;
        console.log('Cart data:', this.cart);
      },
      error: (err) => {
        console.error('Failed to load cart', err);
      }
    });
  }

  removeFromCart(productId: number) {
    this.cartService.removeFromCart(productId).subscribe({
      next: () => this.getCart(),
      error: (err) => console.error('Failed to remove product', err)
    });
  }

  clearCart() {
    this.cartService.clearCart().subscribe({
      next: () => this.getCart(),
      error: (err) => console.error('Failed to clear cart', err)
    });
  }
}
