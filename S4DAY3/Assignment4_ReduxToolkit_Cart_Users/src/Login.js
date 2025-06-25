
import React from 'react';
import { useDispatch } from 'react-redux';
import { login } from './store';

const Login = () => {
  const dispatch = useDispatch();
  return (
    <button onClick={() => dispatch(login({ id: 2, name: 'Toolkit User' }))}>
      Login with Redux Toolkit
    </button>
  );
};

export default Login;
