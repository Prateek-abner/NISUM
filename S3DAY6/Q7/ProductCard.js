import React from 'react';
import { useWishlist } from './useWishlist';

export default function ProductCard({ product }) {
  const { toggleWishlist, isWishlisted } = useWishlist();

  return (
    <div style={{ border: '1px solid #ccc', padding: 10, margin: 10 }}>
      <h3>{product.name}</h3>
      <p>Price: ${product.price}</p>
      <button onClick={() => toggleWishlist(product)} style={{ fontSize: 24, cursor: 'pointer' }}>
        {isWishlisted(product.id) ? '❤️' : '🤍'}
      </button>
    </div>
  );
}
