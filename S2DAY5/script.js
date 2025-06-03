// todo-app/script.js

// Array to store task objects
var tasks = [];

// Function Hoisting: function is declared after it's used
showWelcome();

function showWelcome() {
  console.log("Welcome to To-Do App!");
}

// Function to add a task
function addTask() {
  var taskInput = document.getElementById("taskInput").value;

  if (taskInput === "") {
    alert("Please enter a task!");
    return;
  }

  // Create a task object
  var task = {
    name: taskInput,
    done: false // boolean data type
  };

  tasks.push(task); // Add to array

  document.getElementById("taskInput").value = "";
  alert("Task added!");
}

// Function to display tasks
function showTasks() {
  var taskList = document.getElementById("taskList");
  taskList.innerHTML = ""; // Clear previous list

  // Loop (control flow)
  for (var i = 0; i < tasks.length; i++) {
    var item = document.createElement("li");

    if (tasks[i].done) {
      item.style.textDecoration = "line-through";
    }

    item.textContent = tasks[i].name;

    // Add click to mark as done
    item.onclick = (function(index) {
      return function() {
        tasks[index].done = !tasks[index].done;
        showTasks(); // Refresh the list
      };
    })(i);

    taskList.appendChild(item);
  }
}
