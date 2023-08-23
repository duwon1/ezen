import React, {useState, useEffect} from 'react';
import '../Style/menu.css';
import axios from "axios";
import { useNavigate } from "react-router-dom";

import { useSelector, useDispatch } from 'react-redux';

function FeedView() {
    const [feed, setFeed] =useState({});
    const [imgList, setImgList] =useState([]);
    const [ likeList, setLikeList ] = useState([]);
    const [ replyList, setReplyList ] = useState([]);
    const [ content, setContent ] = useState([]);


    const navigate = useNavigate();
    let user = useSelector( state=>state.user );
    const dispatch = useDispatch();
    if(user.uid===''){navigate('/');}

    useEffect(()=>{
        async function fetchData(){
            const result = await axios.get('/api/feed/feedView');
            const result2 = await axios.post('/api/feed/likeList', {feednum:feed.feedid});
            const result3 = await axios.post('api/feed/getReplys', {feednum:feed.feedid});

            console.log('rep', result3.data.replyList)
            setReplyList([...result3.data.replyList]);
            setLikeList([...result2.data.likeList]);
            setImgList([...result.data.images]);
            setFeed(result.data.feed);
            
            
            
        }   
        fetchData();
    },[])


    


    const moveleft=(feedid, imglength)=>{
        
        let k = document.getElementById( feedid ).style.left;
        console.log('left :', Number(k));
        if(k!=0){
            k = String(k);
            let l = k.length;
            k =Number( k.substring(0, l-2)  );
        }else{
            k = Number(k);
        }
        if(k==0)return;
        console.log('숫자 :', k);
        k = k+700;
        document.getElementById( feedid ).style.left = k + 'px';
    }
    const moveright=(feedid, imglength)=>{
        console.log(imglength);
        let k = document.getElementById( feedid ).style.left;
        console.log('left :', Number(k));
        if(k!=0){
            k = String(k);
            let l = k.length;
            k =Number( k.substring(0, l-2)  );
        }else{
            k = Number(k);
        }
        if( k == (imglength-1)*-700 )return;
        console.log('숫자 :', k);
        k = k-700;
        document.getElementById( feedid ).style.left = k + 'px';
    }




    const onlike= async ( ) => {
        await axios.post('/api/feed/like', {feedid:feed.feedid});
        const result3 = await axios.post('/api/feed/likeList', { feednum:feed.feedid });
        setLikeList([...result3.data.likeList]);
    }
    const onDelike= async () => {
        await axios.post('/api/feed/delike', {feedid:feed.feedid})
        const result3 = await axios.post('/api/feed/likeList', { feednum:feed.feedid });
        setLikeList([...result3.data.likeList]);
    }



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
            <div id='writer'>
                {(feed.profileimg)?(<img src={feed.profileimg} width="40" height="40" id="writerimg"/>):(<img src="http://localhost:5000/no-image.png" width="40" height="40" id="writerimg"/>)}&nbsp;&nbsp; {feed.nick} 
            </div><br />
            <div id="view" >
                <div id={feed.feedid} class='imgList'>
                {
                    imgList.map((img)=>{return (<img src={img.filename} width="700" height="500" className='playimg' />)})
                }
                </div>
                <div className='lbtn' onClick={
                    ()=>{
                        moveleft(feed.feedid, imgList.length);
                    }
                }></div>
                <div className='rbtn'  onClick={
                    ()=>{
                        moveright(feed.feedid, imgList.length);
                    }
                }></div>
            </div>
            <div id="title">
                {(likeList.some((likeuser)=>{return likeuser.likeid==user.uid}))?
                (<img src="http://localhost:5000/delike.png" height="40" onClick={()=>{ onDelike() }}/>):
                (<img src="http://localhost:5000/like.png" height="40" onClick={()=>{ onlike() }}/>)
                }
                &nbsp;좋아요 &nbsp;{likeList.length}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img src="http://localhost:5000/reply.png" height="40" />&nbsp;댓글 &nbsp;{replyList.length}
            </div>
            <hr />
            <div id="title">{feed.title}</div>
            <hr />
            <div id="content" style={{marginBottom:"20px"}}><pre>{feed.content}</pre></div>
            <hr />
            <table width="700">
                {
                    replyList.map((reply, idx)=>{
                        return (
                            <tr>
                                <td width="150" style={{textAlign:"left", fontWeight:"bold"}}>{reply.writer}</td>
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

export default FeedView
