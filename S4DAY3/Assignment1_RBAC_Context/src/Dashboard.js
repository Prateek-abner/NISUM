
import React, { useContext } from 'react';
import { UserContext } from './UserContext';

const Dashboard = () => {
  const { user, login } = useContext(UserContext);

  return (
    <div>
      <h1>User Dashboard</h1>
      {!user?.isLoggedIn && <button onClick={login}>Login</button>}
      {user?.isLoggedIn && <p>Welcome, {user.name}</p>}
      {user?.role === 'admin' && <button>Add Product</button>}
    </div>
  );
};

export default Dashboard;
