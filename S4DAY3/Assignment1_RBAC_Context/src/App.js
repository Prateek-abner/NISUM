
import React, { useContext } from 'react';
import { UserProvider, UserContext } from './UserContext';
import Dashboard from './Dashboard';

function App() {
  return (
    <UserProvider>
      <Dashboard />
    </UserProvider>
  );
}

export default App;
