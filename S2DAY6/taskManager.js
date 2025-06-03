
// Symbol for private ID
const taskId = Symbol("id");

// Enhanced Object Literals + Default Parameters
export class Task {
  constructor(name = "Untitled") {
    this.name = name;
    this.done = false;
    this[taskId] = Date.now(); // unique ID
  }

  toggleDone = () => {
    this.done = !this.done;
  };
}

// Array to store tasks using let
let tasks = [];

// Use of Spread Operator to add task
export const addTask = (task) => {
  tasks = [...tasks, task];
};

// Use of for...of loop and Template Literals
export const listTasks = () => {
  return tasks.map((t, i) => {
    return `<li data-id="${i}">${t.done ? "✅" : "⬜"} ${t.name}</li>`;
  }).join("");
};

// Destructuring + Rest Parameters
export const removeTasks = (...indexes) => {
  tasks = tasks.filter((_, i) => !indexes.includes(i));
};

// Promise for async simulation
export const simulateAsyncSave = () => {
  return new Promise((resolve) => {
    setTimeout(() => resolve("Saved!"), 500);
  });
};

// Export tasks for direct access
export const getTasks = () => tasks;
