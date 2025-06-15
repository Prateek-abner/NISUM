import React from 'react';
import ProductCard from './ProductCard';

function App() {
  return (
    <div>
      <h1>Featured Products</h1>

      
      <ProductCard 
        title="Samsung Galaxy S24" 
        price={999} 
        description="High-performance phone with AI features." 
      />

      <ProductCard />
    </div>
  );
}

export default App;
