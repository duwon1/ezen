import logo from "./logo.svg";
import "./App.css";

// function App() { } <-- commponent : 하나의 단위태그를 리턴해주는 함수
function App() {
  return (
    // return 명령의 입장에서 return 되는 태그는 반드시 하나여야 함
    <>
      <div className="App">
        <header className="App-header">
          <h1>Hello React-App~~!</h1>
          <h2>Welcom to my React</h2>
        </header>
        <h2>Welcom to my React</h2>
      </div>
      <div className="App">
        <header className="App-header">
          <h1>Hello React-App~~!</h1>
          <h2>Welcom to my React</h2>
        </header>
        <h2>Welcom to my React</h2>
      </div>
    </>
  );
}

export default App;
