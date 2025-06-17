import React from 'react';
import { useTheme } from './ThemeContext';

export default function ThemeToggle() {
  const { dark, toggle } = useTheme();
  return (
    <button onClick={toggle}>
      Switch to {dark ? 'Light' : 'Dark'} Theme
    </button>
  );
}
