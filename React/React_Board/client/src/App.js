import { Routes, Route } from "react-router-dom";
import Login from "./Component/Login";
import Main from "./Component/Main";
import MemberJoin from "./Component/MemberJoin"
import UpdateMember from "./Component/UpdateMember";
import BoardView from "./Component/BoardView";
import WriteBoard from "./Component/WriteBoard";
import UpdateBoard from "./Component/UpdateBoard";
import Reply from "./Component/Reply";

import { useState } from "react";

function App() {
  const [message, setMessage] = useState();
  const [boardid, setBoardid] = useState();

  return (
    <>
      <Routes>
        <Route path="/" element={<Login message={message} setMessage={setMessage} />} />
        <Route path="/main" element={<Main message={message} setMessage={setMessage} boardid={boardid} setBoardid={setBoardid} />} />
        <Route path="/memberjoin" element={<MemberJoin message={message} setMessage={setMessage} />} />
        <Route path="/memberEdit" element={<UpdateMember message={message} setMessage={setMessage} />} />
        <Route path="/BoardView" element={<BoardView boardid={boardid} setBoardid={setBoardid} message={message} setMessage={setMessage} />} />
        <Route path="/writeBoard" element={<WriteBoard />} />
        <Route path="/updateBoard" element={<UpdateBoard boardid={boardid} setBoardid={setBoardid} />} />
        <Route path="/reply" element={<Reply />} />
      </Routes>
    </>
  );
}

export default App;
