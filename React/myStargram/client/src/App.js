import React, {useState, useEffect} from 'react'
import {  Routes, Route } from "react-router-dom";
import axios from "axios";

// react-redux 에서 제공하는 redux 내용을 변경하고 추출할 함수들. 
// useSelector : 읽어 오기를 위한 함수
// useDispatch : 내용 변경을 위한 함수
import { useSelector, useDispatch } from 'react-redux';
// loginAction, logoutAction 함수들은 useDispatch를 이용해서 사용합니다.
import { loginAction, logoutAction, setFollowers, setFollowings, removeFollowers, removeFollowings } from './Reducer/userSlice';


import Login from './Component/Login';
import Join from './Component/Join';
import Home from './Component/Home';
import UpdateMember from './Component/UpdateMember';
import MainMenu from './Component/MainMenu';
import WriteFeed from './Component/WriteFeed';
import Mypage from './Component/Mypage';
import FeedView from './Component/FeedView';
import Reply from './Component/Reply';



function App() {
    //const [ loginUser, setLoginUser] = useState({});
    //const [ login, setLogin ] = useState(false);
    //const [ follower, setFollower ] = useState(false);
    //const [ following, setFollowing ] = useState(false);
    const [ viewSearch, setViewSearch] = useState(false);

    const dispatch = useDispatch();  //  redux 변수 의 변경을 위한 함수 추출
    const user = useSelector( state=>state.user ); // redux 변수값 추출해서 user변수에 저장

    useEffect(()=>{
        async function fetchData() {
            try{  
                let result = await axios.get('/api/member/getLoginUser');
                if(result.data.loginUser){
                    // dispatch 안에  loginAction 을 넣고, 변경할 내용을 전달인수로 전달합니다.
                    dispatch( loginAction( result.data.loginUser ) );
                    // redux 에 follower  추가
                    result = await axios.get('/api/member/getFollower');
                    for(let i=0; i<result.data.length; i++){
                        dispatch( setFollowers(result.data[i]) );
                    }
                    // redux 에 following 추가
                    result = await axios.get('/api/member/getFollowing');
                    for(let i=0; i<result.data.length; i++){
                        dispatch( setFollowings(result.data[i]) );
                    }
                }
            }catch(err){  console.error(err);  }
        }
        fetchData();
    }, []);

    useEffect(()=>{
        console.log( 'redux follower : ', user.follower);
        console.log( 'redux following : ', user.following);
    }, [user]);

    return (
        <>
            {(user.uid!='')?(<MainMenu 
                viewSearch={viewSearch}  setViewSearch={setViewSearch}
            />):(null) }
            <Routes>
                <Route path="/" element={<Login /> } /> 
                <Route path="/join" element={<Join />} /> 
                <Route path="/Home" element={<Home 
                    viewSearch={viewSearch}  setViewSearch={setViewSearch}
                />} /> 
                <Route path="/updateMember" element={<UpdateMember /> } />     
                <Route path="/writeFeed" element={ <WriteFeed /> } />  
                <Route path="/mypage" element={<Mypage/>}/>  
                <Route path="/feedView" element={<FeedView />} />  
                <Route path="/reply" element={<Reply />} /> 
                <Route path="/feedView" element={<FeedView />} />
            </Routes>
            
        </>
    );
}

export default App;
