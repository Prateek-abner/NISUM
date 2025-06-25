
import React from 'react';
import { useDispatch } from 'react-redux';
import { login } from './store';

const Login = () => {
  const dispatch = useDispatch();
  return (
    <button onClick={() => dispatch(login({ id: 1, name: 'User' }))}>
      Login
    </button>
  );
};

export default Login;
