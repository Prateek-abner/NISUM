import React from 'react';
import StatusBadge from './StatusBadge';

function App() {
  return (
    <div style={{ padding: '2rem' }}>
      <h2>Status Badges:</h2>
      <StatusBadge status="success" />
      <StatusBadge status="error" />
      <StatusBadge status="warning" />
    </div>
  );
}

export default App;
