import React, { useReducer } from 'react';

const initialState = [];

function reducer(state, action) {
  switch (action.type) {
    case 'ADD':
      return [...state, { id: Date.now(), text: action.payload, completed: false }];
    case 'DELETE':
      return state.filter(todo => todo.id !== action.payload);
    case 'TOGGLE':
      return state.map(todo =>
        todo.id === action.payload ? { ...todo, completed: !todo.completed } : todo
      );
    default:
      return state;
  }
}

function TodoList() {
  const [todos, dispatch] = useReducer(reducer, []);
  const [input, setInput] = React.useState('');

  const completed = todos.filter(todo => todo.completed).length;
  const pending = todos.length - completed;

  return (
    <div>
      <h2>Todo List</h2>
      <form onSubmit={e => {
        e.preventDefault();
        if (input.trim()) {
          dispatch({ type: 'ADD', payload: input });
          setInput('');
        }
      }}>
        <input value={input} onChange={e => setInput(e.target.value)} />
        <button type="submit">Add</button>
      </form>

      <p>✅ Completed: {completed} | ⏳ Pending: {pending}</p>

      <ul>
        {todos.map(todo => (
          <li key={todo.id} style={{ textDecoration: todo.completed ? 'line-through' : '' }}>
            {todo.text}
            <button onClick={() => dispatch({ type: 'TOGGLE', payload: todo.id })}>Toggle</button>
            <button onClick={() => dispatch({ type: 'DELETE', payload: todo.id })}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}
