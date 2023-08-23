// 1. 메인 메뉴를 구성 합니다.
// 2. 메인 메뉴를 클릭하면 해당 페이지로 이동
// 3. Join.js에 회원 가입폼, join.css 를 만들어서 적용 (SpringBoard 양식)
// 4. css 파일은 css 폴더
// 5. Join.js에서 회원가입 버튼을 클릭하면 입력한 정보를 공유된 probs의 리스트에 저장
// 6. result로 이동화면 회원가입 상황을 출력
import React from 'react'
import { Link } from 'react-router-dom'

function Heading() {
    return (
        <div>
            <h1>Hello, React</h1>
            <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
                <Link to="/">home</Link>
                <Link to="/join">join</Link>
                <Link to="/result">result</Link>
            </div>
        </div>
    )
}

export default Heading
