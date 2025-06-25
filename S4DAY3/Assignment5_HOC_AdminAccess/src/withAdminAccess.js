
import React, { useContext } from 'react';
import { UserContext } from './UserContext';

const withAdminAccess = (Component) => {
  return function AdminWrapper(props) {
    const { user } = useContext(UserContext);
    if (user?.role === 'admin') {
      return <Component {...props} />;
    } else {
      return <p>Access Denied</p>;
    }
  };
};

export default withAdminAccess;
