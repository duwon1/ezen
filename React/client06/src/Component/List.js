import React from 'react'

function List(props) {
    return (
        <div style={{ display: "flex", flexDirection: "column", alignItems: "center" }}>
            <h1>
                {/* contentList 에 있는 단어들을 하나씩 출력 */}
                {
                    props.contentList.map((content, index) => {
                        return <div key={index}>{content}</div>
                    })
                }
            </h1>
        </div>
    )
}

export default List
