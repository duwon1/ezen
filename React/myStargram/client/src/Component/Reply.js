import React, {useState, useEffect} from 'react'
import { useNavigate } from "react-router-dom";
import axios from "axios";
import '../Style/home.css';
import { useSelector, useDispatch } from 'react-redux';
import { loginAction, logoutAction, setFollowings } from '../Reducer/userSlice';

function Reply() {
    const navigate = useNavigate();
    const [feed, setFeed] = useState({});
    const [replyList, setReplyList] = useState([]);
    const [content, setContent] = useState('');

    let user = useSelector(state=>state.user);
    const dispatch = useDispatch();
    if(user.uid===''){navigate('/');}

    useEffect(()=>{
        async function fetchData(){
            const result = await axios.get('/api/feed/getFeed');
            setFeed( result.data );
            const result2 = await axios.get('api/feed/getReplyList');
            console.log('reply', result2.data)
            //if( result2.data !== undefined ){
                setReplyList([...result2.data]);
            //}
        }   
        fetchData();
    },[]);
    
    const onSubmit=async ()=>{
        await axios.post('/api/feed/replyWrite', {content});

        const result2 = await axios.get('api/feed/getReplyList');
        if( result2.data !== undefined ){
            setReplyList([...result2.data]);
        }
        setContent('');
    }

    return (
        <div id="wrap">
            <table width="700">
                {
                    replyList.map((reply, idx)=>{
                        return (
                            <tr>
                                <td width="150" style={{textAlign:"center", fontWeight:"bold"}}>{reply.writer}</td>
                                <td style={{textAlign:"left"}}>{reply.content}</td>
                            </tr>   
                        )
                    })
                }
                <tr>
                    <td colSpan="2">
                        <input type="text" id='replyinput' value={content} onChange={(e)=>{
                            setContent( e.currentTarget.value );
                        }} />&nbsp;&nbsp;
                        <button id='replybutton' onClick={()=>{onSubmit();}}>작성</button>
                    </td>
                </tr> 
            </table>
        </div>
    )
}

export default Reply