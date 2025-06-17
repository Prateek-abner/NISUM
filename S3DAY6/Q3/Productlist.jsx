import React, { useState, useEffect, useRef } from 'react';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [filter, setFilter] = useState({ search: '', category: '', min: '', max: '' });
  const [filtered, setFiltered] = useState([]);
  const timeoutRef = useRef(null);

  useEffect(() => {
    fetch('/products.json') // Local or remote file
      .then(res => res.json())
      .then(data => {
        setProducts(data);
        setFiltered(data);
      });
  }, []);

  useEffect(() => {
    clearTimeout(timeoutRef.current);
    timeoutRef.current = setTimeout(() => {
      let result = [...products];
      if (filter.search) result = result.filter(p => p.name.toLowerCase().includes(filter.search.toLowerCase()));
      if (filter.category) result = result.filter(p => p.category === filter.category);
      if (filter.min) result = result.filter(p => p.price >= parseFloat(filter.min));
      if (filter.max) result = result.filter(p => p.price <= parseFloat(filter.max));
      setFiltered(result);
    }, 300);
  }, [filter, products]);

  return (
    <div>
      <h2>Products</h2>
      <input placeholder="Search" onChange={e => setFilter({ ...filter, search: e.target.value })} />
      <select onChange={e => setFilter({ ...filter, category: e.target.value })}>
        <option value="">All</option>
        <option value="Electronics">Electronics</option>
        <option value="Clothes">Clothes</option>
      </select>
      <input type="number" placeholder="Min Price" onChange={e => setFilter({ ...filter, min: e.target.value })} />
      <input type="number" placeholder="Max Price" onChange={e => setFilter({ ...filter, max: e.target.value })} />

      <ul>
        {filtered.map(p => (
          <li key={p.id}>{p.name} - ${p.price}</li>
        ))}
      </ul>
    </div>
  );
}
