import React, { useState } from 'react';

const ThemeToggle = () => {
  const [isDark, setIsDark] = useState(false);

  
  const toggleTheme = () => {
    setIsDark(prev => !prev);
  };

  
  const themeStyle = {
    backgroundColor: isDark ? '#222' : '#f2f2f2',
    color: isDark ? '#fff' : '#000',
    padding: '50px',
    textAlign: 'center',
    minHeight: '100vh',
    transition: 'all 0.3s ease',
  };

  const buttonStyle = {
    padding: '10px 20px',
    fontSize: '16px',
    cursor: 'pointer',
    backgroundColor: isDark ? '#444' : '#ddd',
    color: isDark ? '#fff' : '#000',
    border: 'none',
    borderRadius: '8px',
    marginTop: '20px'
  };

  return (
    <div style={themeStyle}>
      <h1>{isDark ? "Dark Mode" : "Light Mode"}</h1>
      <button style={buttonStyle} onClick={toggleTheme}>
        Toggle Theme
      </button>
    </div>
  );
};

export default ThemeToggle;
