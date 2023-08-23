import React, { useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import Heading from './Component/Heading';
import Join from './Component/Join';
import Result from './Component/Result';

function App() {
  const [userList, setUserList] = useState([])
  return (
    <div className="App">
      <Heading />
      <Routes>
        <Route path='/join' element={<Join userList={userList} setUserList={setUserList} />} />
        <Route path='/result' element={<Result userList={userList} setUserList={setUserList} />} />
      </Routes>
    </div>
  );
}

export default App;
