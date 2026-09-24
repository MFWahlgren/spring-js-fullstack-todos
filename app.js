document.addEventListener("DOMContentLoaded", initApp);

const BASE_URL_TODOS = "https://jsonplaceholder.typicode.com/todos";

async function initApp() {
    await refreshTodos();

    document.querySelector("#todoForm").addEventListener("submit", handleFormSubmit);
    document.querySelector("#todoTableBody").addEventListener("click", handleTableClick);
}

async function refreshTodos() {
    const todos = await fetchTodos();
    displayTodos(todos);
}

async function fetchTodos() {
    try {
        const response = await fetch(BASE_URL_TODOS);
        if (!response.ok) {
            throw new Error(`Failed to fetch todos: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error(error);
        return [];
    }
}

function displayTodos(todos) {
    const tableBody = document.querySelector("#todoTableBody");
    tableBody.innerHTML = ""; // Clear existing rows
    for (const todo of todos) {
        renderTodoRow(todo);
    }
}

function renderTodoRow(todo) {
    const tableBody = document.querySelector("#todoTableBody");

    const row = document.createElement("tr");
    row.setAttribute("data-id", todo.id);

    const titleCell = document.createElement("td");
    titleCell.textContent = todo.title;

    const userIdCell = document.createElement("td");
    userIdCell.textContent = todo.userId;

    const completedCell = document.createElement("td");
    completedCell.textContent = todo.completed ? "Yes" : "No";

    const actionsCell = document.createElement("td");

    const editButton = document.createElement("button");
    editButton.className = "btn btn-warning";
    editButton.setAttribute("data-action", "edit");
    editButton.textContent = "Edit";

    const deleteButton = document.createElement("button");
    deleteButton.className = "btn btn-danger";
    deleteButton.setAttribute("data-action", "delete");
    deleteButton.textContent = "Delete";

    actionsCell.append(editButton, deleteButton);
    row.append(titleCell, userIdCell, completedCell, actionsCell);
    tableBody.appendChild(row);
}

async function addTodo(todo) {
    try {
        const response = await fetch(BASE_URL_TODOS, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(todo)
        });
        if (!response.ok) {
            throw new Error(`Failed to add todo: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error(error);
    }
}

async function updateTodo(id, updatedTodo) {
    try {
        const response = await fetch(`${BASE_URL_TODOS}/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(updatedTodo)
        });
        if (!response.ok) {
            throw new Error(`Failed to update todo: ${response.status}`);
        }
        return await response.json();
    } catch (error) {
        console.error(error);
    }
}

async function deleteTodo(id) {
    try {
        const response = await fetch(`${BASE_URL_TODOS}/${id}`, {
            method: "DELETE"
        });
        if (!response.ok) {
            throw new Error(`Failed to delete todo: ${response.status}`);
        }
        return true;
    } catch (error) {
        console.error(error);
        return false;
    }
}

async function handleFormSubmit(event) {
    event.preventDefault();
    const form = new FormData(event.target);
    const id = form.get("id");
    const title = form.get("title");
    const userId = Number(form.get("userId"));
    const completed = form.get("completed") === "on";

    const todoData = { title, userId, completed };

    if (id) {
        await updateTodo(id, todoData);
    } else {
        await addTodo(todoData);
    }

    event.target.reset();
    document.querySelector("#todoId").value = "";

    await refreshTodos();
}

async function handleTableClick(event) {
    const action = event.target.getAttribute("data-action");
    const row = event.target.closest("tr");
    const id = row.getAttribute("data-id");

    if (action === "delete") {
        await deleteTodo(id);
        await refreshTodos();
    } else if (action === "edit") {
        const title = row.children[0].textContent;
        const userId = row.children[1].textContent;
        const completed = row.children[2].textContent === "Yes";

        document.querySelector("#todoId").value = id;
        document.querySelector("#todoTitle").value = title;
        document.querySelector("#userId").value = userId;
        document.querySelector("#completed").checked = completed;
    }
}
