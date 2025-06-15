import React from 'react';

const TodoList = ({ todos }) => {
  return (
    <div>
      <h2>Todo List</h2>
      <ul>
        {todos.map((todo, index) => (
          <li key={index}>{todo}</li>
        ))}
      </ul>
    </div>
  );
};


TodoList.defaultProps = {
  todos: ['Buy groceries', 'Walk the dog', 'Read a book']
};

export default TodoList;
