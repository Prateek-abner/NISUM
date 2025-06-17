
import React, { useEffect, useState } from 'react';
import { useParams, useNavigate, Link } from 'react-router-dom';

export default function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    fetch('/products.json')
      .then(res => res.json())
      .then(data => {
        const found = data.find(p => p.id === parseInt(id));
        setProduct(found);
      });
  }, [id]);

  if (!product) return <p>Loading...</p>;

  return (
    <div>
      <nav>
        <Link to="/">Home</Link> / {product.name}
      </nav>
      <h2>{product.name}</h2>
      <img src={product.image} alt="" width={150} />
      <p>{product.description}</p>
      <p>💲 {product.price}</p>
      <p>{product.stock > 0 ? 'In Stock' : 'Out of Stock'}</p>
      <button onClick={() => navigate(-1)}>Go Back</button>
    </div>
  );
}
