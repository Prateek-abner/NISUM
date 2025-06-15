import React, { useState } from 'react';
import NavItem from './NavItem';
import './Navbar.css';

const Navbar = () => {
  const [activeTab, setActiveTab] = useState('Home');

  const tabs = ['Home', 'About', 'Services', 'Contact'];

  return (
    <nav className="navbar">
      <div className="nav-logo">MySite</div>
      <div className="nav-items">
        {tabs.map(tab => (
          <NavItem
            key={tab}
            label={tab}
            isActive={activeTab === tab}
            onClick={() => setActiveTab(tab)}
          />
        ))}
      </div>
    </nav>
  );
};

export default Navbar;
