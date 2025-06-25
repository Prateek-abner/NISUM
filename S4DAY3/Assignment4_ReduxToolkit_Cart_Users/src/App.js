
import React from 'react';
import { Provider } from 'react-redux';
import store from './store';
import Login from './Login';
import Cart from './Cart';

function App() {
  return (
    <Provider store={store}>
      <Login />
      <Cart />
    </Provider>
  );
}

export default App;
