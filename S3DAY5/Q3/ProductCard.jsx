import React from 'react';
import './ProductCard.css'; 

const ProductCard = ({ title, price, description }) => {

  const inlineStyle = {
    border: '1px solid black',
    padding: '16px',
    borderRadius: '8px',
    marginBottom: '20px',
    backgroundColor: '#f9f9f9'
  };

  return (
    <div className="product-card" style={inlineStyle}>
      <h2 style={{ color: '#333' }}>{title}</h2>
      <p style={{ fontWeight: 'bold' }}>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
};

ProductCard.defaultProps = {
  title: "iPhone 15",
  price: 1099,
  description: "Latest model with improved battery life."
};

export default ProductCard;
