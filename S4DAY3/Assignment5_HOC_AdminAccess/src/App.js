
import React from 'react';
import ProductEdit from './ProductEdit';
import { UserContext, UserProvider } from './UserContext';

function App() {
  return (
    <UserProvider>
      <ProductEdit />
    </UserProvider>
  );
}

export default App;
