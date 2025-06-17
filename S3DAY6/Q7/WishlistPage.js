
import React from 'react';
import { useWishlist } from './useWishlist';

export default function WishlistPage() {
  const { wishlist } = useWishlist();

  return (
    <div>
      <h2>❤️ Your Wishlist</h2>
      {wishlist.length === 0 ? (
        <p>No items in wishlist.</p>
      ) : (
        <ul>
          {wishlist.map((item) => (
            <li key={item.id}>
              {item.name} - ${item.price}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}
