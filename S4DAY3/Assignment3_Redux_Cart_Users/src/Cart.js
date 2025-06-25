
import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { addItem } from './store';

const Cart = () => {
  const cart = useSelector(state => state.cart);
  const dispatch = useDispatch();

  return (
    <div>
      <button onClick={() => dispatch(addItem({ id: Date.now(), name: 'Product' }))}>
        Add Product
      </button>
      <p>Items in Cart: {cart.length}</p>
    </div>
  );
};

export default Cart;
