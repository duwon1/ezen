const loginForm= document.querySelector("#login-form");
const loginInput = document.querySelector("#login-form input");
const greeting = document.querySelector("#greeting");

const HIDDEN_CLASSNAME= "hidden";
const USERNAME_KEY="username";

function onLoginSubmit(event){   //after I submit
    event.preventDefault();
    loginForm.classList.add('hidden');
    const username = loginInput.value;
    localStorage.setItem(USERNAME_KEY,username);
    paintGreetings(username);
}

function paintGreetings(username){
    greeting.classList.remove(HIDDEN_CLASSNAME);
    greeting.innerText=`Hello ${username}`;
}

const savedUsername= localStorage.getItem(USERNAME_KEY);
console.log(savedUsername);

if(savedUsername===null){
    //show the form
    loginForm.classList.remove(HIDDEN_CLASSNAME);
    loginForm.addEventListener('submit', onLoginSubmit);

}else{
    //show the greetings
 paintGreetings(savedUsername);
}
