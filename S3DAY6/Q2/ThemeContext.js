import React, { createContext, useState, useContext } from 'react';

const ThemeContext = createContext();

export function ThemeProvider({ children }) {
  const [dark, setDark] = useState(false);
  const toggle = () => setDark(prev => !prev);

  return (
    <ThemeContext.Provider value={{ dark, toggle }}>
      <div style={{
        background: dark ? '#333' : '#fff',
        color: dark ? '#fff' : '#000',
        minHeight: '100vh',
        padding: '1rem',
      }}>
        {children}
      </div>
    </ThemeContext.Provider>
  );
}

export const useTheme = () => useContext(ThemeContext);
