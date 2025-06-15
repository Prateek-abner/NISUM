import React from 'react';

const ProductCard = ({ title, price, description }) => {
  return (
    <div className="product-card">
      <h2>{title}</h2>
      <p>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
};

// Default props
ProductCard.defaultProps = {
  title: "iPhone 15",
  price: 1099,
  description: "Latest model with improved battery life."
};

export default ProductCard;

