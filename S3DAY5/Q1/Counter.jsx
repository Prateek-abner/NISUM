import React, { useState, useEffect } from 'react';
import './Counter.css'; 

const Counter = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log(`Count changed to: ${count}`);
  }, [count]);

  const handleIncrement = () => setCount(count + 1);
  const handleDecrement = () => setCount(count - 1);
  const handleReset = () => setCount(0);

  return (
    <div className="counter-container">
      <h1>Count: {count}</h1>
      <button className="increment" onClick={handleIncrement}>Increment</button>
      <button className="decrement" onClick={handleDecrement} disabled={count === 0}>Decrement</button>
      <button className="reset" onClick={handleReset}>Reset</button>
    </div>
  );
};

export default Counter;
