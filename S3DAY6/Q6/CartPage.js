import React from 'react';
import { useCart } from './CartContext';

export default function CartPage() {
  const { cart, increment, decrement, removeFromCart, clearCart } = useCart();

  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);

  return (
    <div>
      <h2>🛒 Your Cart</h2>
      {cart.length === 0 ? <p>Cart is empty</p> :
        <ul>
          {cart.map(item => (
            <li key={item.id}>
              {item.name} - ${item.price} x {item.quantity}
              <div>
                <button onClick={() => decrement(item.id)} disabled={item.quantity === 1}>-</button>
                <button onClick={() => increment(item.id)}>+</button>
                <button onClick={() => removeFromCart(item.id)}>Remove</button>
              </div>
            </li>
          ))}
        </ul>}
      <p>Total: ${total.toFixed(2)}</p>
      <button onClick={clearCart}>Clear Cart</button>
    </div>
  );
}
