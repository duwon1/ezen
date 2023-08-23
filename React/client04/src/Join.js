import React from "react";

// 아이디 비번 비번확인 이름 이메일을 입력받는 join 컴포넌트를 만들고, 회원가입을 누르면 폼 아래에 세부내역이 출력되게 하세요

function Join() {
    const [id, setId] = React.useState("");
    const [pw, setPw] = React.useState("");
    const [pwchk, setPwchk] = React.useState("");
    const [name, setName] = React.useState("");
    const [email, setEmail] = React.useState("");
    const [userList, setUserList] = React.useState([]);

    
    const submit = () => {
        if(id === "" || pw === "" || pwchk === "" || name === "" || email === "") {
            alert("필수항목을 모두 입력해주세요.");
        } else if(pw!== pwchk) {
            alert("비밀번호가 일치하지 않습니다.");
        } else {
            if(userList != null) {
                setUserList([...userList, {
                    id: id,
                    pw: pw,
                    name: name,
                    email: email
                }])
            } else {
                setUserList([{
                    id: id,
                    pw: pw,
                    name: name,
                    email: email
                }])
            }
            setId("");
            setPw("");
            setPwchk("");
            setName("");
            setEmail("");
            alert("회원가입이 완료되었습니다.");
           console.log(userList)
        }

        
    }
    
  return (
    <div>
      <form>
        아이디 : <input type="text" value={id} onChange={(e) => {
            setId(e.target.value);
        }}/><br />
        비밀번호 : <input type="password" value={pw} onChange={(e) => {
            setPw(e.target.value);
        }}/><br />
        비밀번호 확인 : <input type="password" value={pwchk} onChange={(e) => {
            setPwchk(e.target.value);
        }}/><br />
        이름 : <input type="text" value={name} onChange={(e) => {
            setName(e.target.value);
        }}/><br />
        이메일 : <input type="text" value={email} onChange={(e) => {
            setEmail(e.target.value);
        }}/><br />
        <input type="button" value="회원가입" onClick={() => {
            submit();
        }}/>
      </form>
      {
        userList.map((item, index) => {
            return (
                <div key={index} style={{marginTop:"30px"}}>
                    {index + 1} 번째 계정 <br />
                    아이디 : {item.id} <br />
                    비밀번호 : {item.pw} <br />
                    이름 : {item.name} <br />
                    이메일 : {item.email} <br />

                </div>
            );
        })
      }
    </div>
  );
}

export default Join;
