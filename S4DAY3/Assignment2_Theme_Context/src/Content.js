
import React from 'react';
import { useTheme } from './ThemeContext';

const Content = () => {
  const { theme } = useTheme();
  return (
    <div style={{ backgroundColor: theme === 'dark' ? '#222' : '#fff', color: theme === 'dark' ? '#fff' : '#000', padding: 20 }}>
      <h1>This is the content area</h1>
    </div>
  );
};

export default Content;
