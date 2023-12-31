const toDoForm = document.getElementById("todo-form");
const toDoInput =toDoForm.querySelector("input");
// const toDoInput =document.querySelector("#todo-form input"); 과 동일
const toDoList=document.getElementById("todo-list");

const TODOS_KEY="todos";

const toDos= [];

function deleteToDo(event){
    const li=event.target.parentElement;
    li.remove();
}

function saveToDos(){
    localStorage.setItem(TODOS_KEY,JSON.stringify(toDos));
   
}


function paintToDo(newTodo){
const li = document.createElement('li');
const span = document.createElement('span');
span.innerText=newTodo;
const button = document.createElement("button");
button.innerText="❌";
button.addEventListener("click",deleteToDo)

li.appendChild(span);
li.appendChild(button);
toDoList.appendChild(li);

}

function handleToDoSubmit(event){
    event.preventDefault();
    const newTodo=toDoInput.value;
    toDoInput.value="";
    toDos.push(newTodo);
    paintToDo(newTodo);
    saveToDos();
}

toDoForm.addEventListener("submit", handleToDoSubmit);

// function sayHello(item){
//     console.log("hello",item);
// }


const savedToDos=localStorage.getItem(TODOS_KEY);

if(savedToDos!== null){
    const parsedToDos=JSON.parse(savedToDos);
    parsedToDos.forEach((item)=>console.log("hello",item));
}