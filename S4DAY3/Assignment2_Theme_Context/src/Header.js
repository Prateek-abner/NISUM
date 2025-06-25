
import React from 'react';
import { useTheme } from './ThemeContext';

const Header = () => {
  const { theme, toggleTheme } = useTheme();
  return (
    <header style={{ backgroundColor: theme === 'dark' ? '#333' : '#eee', padding: 10 }}>
      <button onClick={toggleTheme}>Toggle Theme</button>
    </header>
  );
};

export default Header;
