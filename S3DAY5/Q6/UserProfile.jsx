import React from 'react';
import './UserCard.css';

const UserProfile = ({ name, email, avatarUrl, bio }) => {
  const defaultAvatar = "https://via.placeholder.com/100";

  return (
    <div className="user-card">
      <img src={avatarUrl || defaultAvatar} alt={name} className="avatar" />
      <div className="user-info">
        <h2>{name}</h2>
        <p className="email">{email}</p>
        <p className="bio">{bio}</p>
      </div>
    </div>
  );
};


UserProfile.defaultProps = {
  name: "John Doe",
  email: "john@example.com",
  avatarUrl: "",
  bio: "This is a sample user bio."
};

export default UserProfile;
