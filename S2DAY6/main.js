
import { Task, addTask, listTasks, getTasks, simulateAsyncSave } from './taskManager.js';

const addBtn = document.getElementById("addBtn");
const input = document.getElementById("taskInput");
const taskList = document.getElementById("taskList");

// WeakMap to store DOM -> Task mapping
const domTaskMap = new WeakMap();

addBtn.addEventListener("click", () => {
  const name = input.value.trim();
  if (!name) return;

  const newTask = new Task(name);
  addTask(newTask);
  render();
  input.value = "";

  simulateAsyncSave().then(console.log);
});

// Generator for listing done tasks only
function* doneTasksGen(tasks) {
  for (const t of tasks) {
    if (t.done) yield t;
  }
}

// Render using Array.from()
const render = () => {
  taskList.innerHTML = listTasks();

  Array.from(taskList.children).forEach((li, index) => {
    li.addEventListener("click", () => {
      const task = getTasks()[index];
      task.toggleDone();
      render();
    });

    // Set task object using WeakMap
    domTaskMap.set(li, getTasks()[index]);
  });

  console.log("✅ Done Tasks:");
  const gen = doneTasksGen(getTasks());
  for (const t of gen) {
    console.log(t.name);
  }
};

// Examples: Map, Set, Object.assign, Object.is, Array.of
const exampleStuff = () => {
  const map = new Map();
  const set = new Set(["one", "two"]);

  const taskA = new Task("Map Test");
  map.set("task", taskA);

  const cloned = Object.assign({}, taskA);
  console.log("Cloned with assign:", cloned);

  console.log("is equal:", Object.is(taskA, cloned)); // false

  console.log("Array.of example:", Array.of(1, 2, 3));
};

exampleStuff();
