import React from 'react';
import UserProfile from './UserProfile';
import Notifications from './Notifications';

function App() {
  const notificationsData = [
    { message: "New message from Sarah", date: "2025-06-15", time: "10:30 AM", status: "Unread" },
    { message: "Your order was shipped", date: "2025-06-14", time: "4:00 PM", status: "Read" },
    { message: "New comment on your post", date: "2025-06-13", time: "8:15 AM", status: "Unread" }
  ];

  return (
    <div>
      <UserProfile />
      <Notifications items={notificationsData} />
    </div>
  );
}

export default App;
