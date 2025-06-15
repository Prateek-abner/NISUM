import React from 'react';
import './Layout.css';

const Layout = ({ children }) => {
  return (
    <div className="layout">
      <header className="header">My Website</header>
      <main className="content">{children}</main>
      <footer className="footer">© 2025 My Website. All rights reserved.</footer>
    </div>
  );
};

export default Layout;
