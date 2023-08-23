import React, { useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';

import Heading from './Component/Heading';
import List from './Component/List';
import Upload from './Component/Upload';
import Join from './Component/Join';
import Member from './Component/Member';


function App() {
    // 컴포넌트 간의 state 변수를 공유하려면 그들을 함께 컨트롤하고 있는 상위 컴포넌트에서 변수 값을 공유하도록 합니다.
    const [contentList, setContentList] = useState([])

    return (
        <>
            <Heading />
            <Routes>
                <Route path='/Member' element={<Member />} />
                <Route path='/Join' element={<Join />} />
                <Route path='/List' element={<List contentList={contentList} setContentList={setContentList} />} />
                <Route path='/Upload' element={<Upload contentList={contentList} setContentList={setContentList} />} />
            </Routes>
        </>
    );
}

export default App;
