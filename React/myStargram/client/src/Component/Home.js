import React, {useState, useEffect} from 'react'
import { useNavigate } from "react-router-dom";
import axios from "axios";
import '../Style/home.css';
import { useSelector, useDispatch } from 'react-redux';
import { loginAction, logoutAction, setFollowings } from '../Reducer/userSlice';


function Home(props) {
    const navigate = useNavigate();
    const [ feedList, setFeedList ] = useState([]);
    const [ imageList, setImageList ] = useState([]);
    const [ likeList, setLikeList ] = useState([]);
    const [ replyList, setReplyList ] = useState([]);
    const [ key, setKey] = useState('');
    const [following, setFollowing] = useState([]);
    

    let temp1 = [];
    let temp2 = [];
    let temp3 = [];

    let user = useSelector(state=>state.user);
    const dispatch = useDispatch();
    if(user.uid===''){navigate('/');}


    useEffect(()=>{
        async function fetchData(){
            console.log(1);
            try{
                const result = await axios.get('/api/feed/getFeedList');     
                console.log(result.data);         
                for(let i=0; i<result.data.length; i++){
                    const result2 = await axios.post('/api/feed/imgList', { feednum:result.data[i].feedid });
                    let arr = [];                   
                    for(let j = 0; j<result2.data.length; j++){
                        arr.push(result2.data[j].filename);
                    }
                    temp1.push(arr);
                    const result3 = await axios.post('/api/feed/likeList', { feednum:result.data[i].feedid });
                    temp2.push( result3.data.likeList );

                    const result4 = await axios.post('api/feed/getReplys', { feednum:result.data[i].feedid });
                    temp3.push( result4.data.replyList );
                }
                console.log(2);
                setFeedList([...result.data] );
                setImageList([...temp1]);
                setLikeList([...temp2]);
                setReplyList([...temp3]);
            }catch(err){
                console.error('error:', err);
            }
        }
        fetchData();       
        
    }, []);

    

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

    const onFollow=async (feedwriter)=>{
        await axios.post( '/api/member/follow', { FollowingId:feedwriter, FollowerId:user.uid });
        //window.location.reload();
        let result = await axios.get('/api/member/getFollowing');
        //props.setFollowing( [...result.data] );
        dispatch( setFollowings({id:user.uid, email:user.email, nick:user.nick}) );
        setFollowing([...user.following]);
    }


    const onlike= async (feedid) => {
        await axios.post('/api/feed/like', {feedid})
        //window.location.reload();
        temp2=[];
        for(let i=0; i<feedList.length; i++){
            const result3 = await axios.post('/api/feed/likeList', { feednum:feedList[i].feedid });
            temp2.push( result3.data.likeList );
        }
        setLikeList([...temp2]);
    }
    const onDelike= async (feedid) => {
        await axios.post('/api/feed/delike', {feedid})
        //window.location.reload();
        temp2=[];
        for(let i=0; i<feedList.length; i++){
            const result3 = await axios.post('/api/feed/likeList', { feednum:feedList[i].feedid });
            temp2.push( result3.data.likeList );
        }
        setLikeList([...temp2]);
    }


    const onReplyView=async (feedid)=>{
        axios.post('/api/feed/feedidsave', {feedid});
        navigate('/reply');
    };

    const onSearch = async ()=>{
        
        const result = await axios.post('/api/feed/getFeedSearch', {key});
        for(let i=0; i<result.data.length; i++){
            const result2 = await axios.post('/api/feed/imgList', { feednum:result.data[i].feedid });
            let arr = [];                   
            for(let j = 0; j<result2.data.length; j++){
                arr.push(result2.data[j].filename);
            }
            temp1.push(arr);
            const result3 = await axios.post('/api/feed/likeList', { feednum:result.data[i].feedid });
            temp2.push( result3.data.likeList );

            const result4 = await axios.post('api/feed/getReplys', { feednum:result.data[i].feedid });
            temp3.push( result4.data.replyList );
        }
        setFeedList([...result.data] );
        setImageList([...temp1]);
        setLikeList([...temp2]);
        setReplyList([...temp3]);
        

    }


    const feedView=async (feedid)=>{
        axios.post('/api/feed/feedidsave', {feedid});
        navigate('/feedView');
    }

    return (
        <div id="wrap">
            {(props.viewSearch)?(
                <>
                    <input type="text" id='replyinput' style={{width:"430px"}} value={key} onChange={(e)=>{
                        setKey( e.currentTarget.value );
                    }} />&nbsp;&nbsp;
                    <button id='replybutton' style={{width:"130px"}} onClick={()=>{onSearch();}}>해시테그 검색</button>&nbsp;&nbsp;
                    <button id='replybutton' onClick={()=>{window.location.reload();}}>전체보기</button>
                    <br /><br /><br />
                </>
            ):(null)}
            <div id="feed">
                {
                    feedList.map((feed, k)=>{
                        return (
                            <div key={k}>
                                <div id='writer'>
                                    {(feed.profileimg)?(<img src={feed.profileimg} width="40" height="40" id="writerimg"/>):(<img src="http://localhost:5000/no-image.png" width="40" height="40" id="writerimg"/>)}
                                    &nbsp;&nbsp;
                                    {feed.nick} 
                                    {
                                        ( !following.some( (item)=>{return item.id == feed.writer} )  && feed.writer != user.uid  )?
                                        (<div id="follow" onClick={()=>{
                                            onFollow(feed.writer)
                                        }}>팔로우</div>):
                                        (null)                                        
                                    }

                                </div><br />
                                <div id="view" >
                                    <div id={feed.feedid} className='imgList' onClick={()=>{ feedView(feed.feedid) }}>
                                        {
                                            imageList[k].map((img, i)=>{return (<img key={i} src={img} width="700" height="500" className='playimg' />)})}
                                    </div>
                                    <div className='lbtn' onClick={
                                        ()=>{
                                            moveleft(feed.feedid, imageList[k].length);
                                        }
                                    }></div>
                                    <div className='rbtn'  onClick={
                                        ()=>{
                                            moveright(feed.feedid, imageList[k].length);
                                        }
                                    }></div>
                                </div>
                                <div id="title">
                                    {(likeList[k].some((likeuser)=>{return likeuser.likeid==user.uid}))?
                                    (<img src="http://localhost:5000/delike.png" height="40" onClick={()=>{ onDelike(feed.feedid) }}/>):
                                    (<img src="http://localhost:5000/like.png" height="40" onClick={()=>{ onlike(feed.feedid) }}/>)
                                    }
                                    &nbsp;좋아요 &nbsp;{likeList[k].length}
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <img src="http://localhost:5000/reply.png" height="40" onClick={()=>{
                                        onReplyView(feed.feedid);
                                    }}/>&nbsp;댓글 &nbsp;{replyList[k].length}
                                </div>

                                 
                                
                                <div id="title">{feed.title}</div>
                                <div id="content"><pre>{feed.content}</pre></div>
                            </div>
                        )
                    })
                } 
            </div> <br /><br /><br /><br />             
        </div>
    )
}

export default Home
