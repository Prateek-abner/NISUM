import React, { useState, useEffect, useRef, useCallback } from 'react';

export default function InfiniteProducts() {
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true);
  const [loading, setLoading] = useState(false);
  const [category, setCategory] = useState('All');
  const loader = useRef();

  const fetchProducts = async () => {
    setLoading(true);
    const res = await fetch(`/api/products?page=${page}&limit=10&category=${category}`);
    const data = await res.json();
    setProducts(prev => [...prev, ...data]);
    if (data.length < 10) setHasMore(false);
    setLoading(false);
  };

  useEffect(() => {
    fetchProducts();
  }, [page, category]);

  const observer = useRef();
  const lastRef = useCallback(node => {
    if (loading) return;
    if (observer.current) observer.current.disconnect();
    observer.current = new IntersectionObserver(entries => {
      if (entries[0].isIntersecting && hasMore) setPage(p => p + 1);
    });
    if (node) observer.current.observe(node);
  }, [loading, hasMore]);

  const changeCategory = (cat) => {
    setProducts([]);
    setPage(1);
    setHasMore(true);
    setCategory(cat);
  };

  return (
    <div>
      <h2>Products</h2>
      <div>
        {['All', 'Electronics', 'Books', 'Clothing'].map(cat => (
          <button key={cat} onClick={() => changeCategory(cat)}>
            {cat}
          </button>
        ))}
      </div>

      <ul>
        {products.map((product, idx) => (
          <li key={product.id} ref={idx === products.length - 1 ? lastRef : null}>
            {product.name}
          </li>
        ))}
      </ul>

      {loading && <p>Loading...</p>}
    </div>
  );
}
