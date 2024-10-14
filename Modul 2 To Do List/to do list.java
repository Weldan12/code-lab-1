let inputTodo = document.getElementById('input-todo');
let btnTambah = document.getElementById('btn-tambah');
let listTodo = document.getElementById('list-todo');

let todos = [];

btnTambah.addEventListener('click', function() {
    let todo = inputTodo.value.trim();
    if (todo !== '') {
        todos.push(todo);
        renderTodoList();
        inputTodo.value = '';
    }
});

function renderTodoList() {
    listTodo.innerHTML = '';
    todos.forEach(function(todo, index) {
        let todoItem = document.createElement('li');
        todoItem.classList.add('todo-item');
        todoItem.innerHTML = `
            <span>${todo}</span>
            <button class="btn-edit" data-index="${index}">Edit</button>
            <button class="btn-hapus" data-index="${index}">Hapus</button>
        `;
        listTodo.appendChild(todoItem);
    });
}

listTodo.addEventListener('click', function(event) {
    if (event.target.classList.contains('btn-edit')) {
        let index = event.target.dataset.index;
        let todo = todos[index];
        let newTodo = prompt('Edit todo:', todo);
        if (newTodo !== null) {
            todos[index] = newTodo;
            renderTodoList();
        }