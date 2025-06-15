import React from 'react';
import TodoList from './TodoList';

function App() {
  const myTodos = ['Finish assignment', 'Call mom', 'Go for a run'];

  return (
    <div>
      <h1>My Tasks</h1>


      <TodoList todos={myTodos} />

      <TodoList />
    </div>
  );
}

export default App;
