import React, { createContext, useReducer, useContext } from 'react';

const CartContext = createContext();

const initialState = [];

function cartReducer(state, action) {
  switch (action.type) {
    case 'ADD':
      const exists = state.find(p => p.id === action.payload.id);
      if (exists) {
        return state.map(p => p.id === action.payload.id ? { ...p, quantity: p.quantity + 1 } : p);
      }
      return [...state, { ...action.payload, quantity: 1 }];
    case 'REMOVE':
      return state.filter(p => p.id !== action.payload);
    case 'CLEAR':
      return [];
    case 'INCREMENT':
      return state.map(p => p.id === action.payload ? { ...p, quantity: p.quantity + 1 } : p);
    case 'DECREMENT':
      return state.map(p =>
        p.id === action.payload && p.quantity > 1 ? { ...p, quantity: p.quantity - 1 } : p
      );
    default:
      return state;
  }
}

export function CartProvider({ children }) {
  const [cart, dispatch] = useReducer(cartReducer, initialState);

  const addToCart = (product) => dispatch({ type: 'ADD', payload: product });
  const removeFromCart = (id) => dispatch({ type: 'REMOVE', payload: id });
  const clearCart = () => dispatch({ type: 'CLEAR' });
  const increment = (id) => dispatch({ type: 'INCREMENT', payload: id });
  const decrement = (id) => dispatch({ type: 'DECREMENT', payload: id });

  return (
    <CartContext.Provider value={{ cart, addToCart, removeFromCart, clearCart, increment, decrement }}>
      {children}
    </CartContext.Provider>
  );
}

export const useCart = () => useContext(CartContext);
