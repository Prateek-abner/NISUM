import React from 'react';
import './Notifications.css';

const Notifications = ({ items }) => {
  return (
    <div className="notifications">
      <h2>Notifications</h2>
      <ul>
        {items.map((note, index) => (
          <li key={index} className={`notification ${note.status.toLowerCase()}`}>
            <div className="note-content">
              <p>{note.message}</p>
              <span>{note.date} @ {note.time}</span>
            </div>
            <span className="status">{note.status}</span>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Notifications;
