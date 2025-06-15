import React from 'react';
import UserProfile from './UserProfile';
import Notifications from './Notifications';

const Dashboard = () => {
  const userData = {
    name: 'Jane Smith',
    email: 'jane.smith@example.com',
    avatarUrl: 'https://i.pravatar.cc/100?img=3',
    bio: 'Frontend developer with a passion for UI/UX design.'
  };

  const notificationsData = [
    { message: "Project update available", date: "2025-06-14", time: "3:45 PM", status: "Read" },
    { message: "New follower: John", date: "2025-06-15", time: "9:00 AM", status: "Unread" },
    { message: "System maintenance tonight", date: "2025-06-13", time: "11:30 PM", status: "Unread" }
  ];

  return (
    <div className="dashboard">
      <h1>Welcome to Your Dashboard</h1>
      <UserProfile
        name={userData.name}
        email={userData.email}
        avatarUrl={userData.avatarUrl}
        bio={userData.bio}
      />
      <Notifications items={notificationsData} />
    </div>
  );
};

export default Dashboard;
