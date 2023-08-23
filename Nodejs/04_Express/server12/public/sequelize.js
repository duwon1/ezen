getusers()
getcomments()

document.getElementById('user_form').addEventListener('submit', async (e) => {
  e.preventDefault()
  const name = e.target.username.value
  const age = e.target.age.value
  const married = e.target.married.checked
  if (!name) {
    return alert('이름을 입력하세요')
  } else if (!age) {
    return alert('나이를 입력하세요')
  }

  try {
    await axios.post('/users/insert', {
      name,
      age,
      married
    })
    getusers()
  } catch (err) {
    console.log(err)
  }

  e.target.username.value = ''
  e.target.age.value = ''
  e.target.married.checked = false
})

async function getusers() {
  // 모든 user 를 조회해서 user-list 테이블에 표시한다.
  try {
    const result = await axios.get('/users')
    const users = result.data

    const tbody = document.querySelector('#user-list tbody')
    tbody.innerHTML = ''

    users.map((user) => {
      const row = document.createElement('tr') // tr 태그생성
      var td = document.createElement('td') // td 태그생성

      td.textContent = user.id // 생성된 태그에 user 의 id 삽입
      row.appendChild(td) // tr 안에 td 삽입

      td = document.createElement('td')
      td.textContent = user.name
      row.appendChild(td)

      td = document.createElement('td')
      td.textContent = user.age
      row.appendChild(td)

      td = document.createElement('td')
      td.textContent = user.married ? '기혼' : '미혼'
      row.appendChild(td)

      row.addEventListener('click', async (e) => {
        // 현재 사용자의 id로 comment 테이블을 조회하고 그결과를 comment-list 테이블에 출력한다.
        getCommentById(user.id)
        // 현재행의 사용자 id 를 전달인수로 전달

      })

      tbody.appendChild(row)
    })

  } catch (error) {
    console.error(error)
  }
}

async function getCommentById(id) {
  try {
    const result = await axios.get(`/comments/search/${id}`)
    const comments = result.data
    const tbody = document.querySelector('#comment_list tbody')
    tbody.innerHTML = ''

    comments.map((comment) => {
      const row = document.createElement('tr')

      let td = document.createElement('td')
      td.textContent = comment.id // 댓글번호
      row.appendChild(td)

      td = document.createElement('td')
      //td.textContent = comment.User.name
      td.textContent = comment.commenter
      row.appendChild(td)

      td = document.createElement('td')
      td.textContent = comment.comment
      row.appendChild(td)

      // 수정버튼
      const edit = document.createElement('button')
      edit.textContent = '수정'
      td = document.createElement('td') // td 생성
      td.appendChild(edit) // 버튼을 td에 추가
      row.appendChild(td) // 버튼이 든 td 를 tr에 추가
      edit.addEventListener('click', async (e) => {
        try {
          const newComment = prompt('바꿀 내용을 입력하세요')
          if (!newComment) {
            return alert('내용을 입력하세요')
          }
          // http://localhost:3000/comments/update/???
          await axios.patch('/comments/update/' + comment.id, { comment: newComment })
          getcomments()
        } catch (err) {
          console.error(err)
        }
      })

      // 삭제버튼
      const del = document.createElement('button')
      del.textContent = '삭제'
      td = document.createElement('td')
      td.appendChild(del)
      row.appendChild(td)
      tbody.appendChild(row)

      del.addEventListener('click', async (e) => {
        try {
          const result = confirm('삭제하시겠습니까?')
          if (result) {
            await axios.delete('/comments/delete/' + comment.id)
          }
          getcomments()
        } catch (error) {
          console.error(error)
        }
      })
    })



  } catch (e) {
    console.error(e)
  }
}

document.getElementById('comment_form').addEventListener('submit', async (e) => {
  e.preventDefault()
  const id = e.target.userid.value
  const comment = e.target.comment.value

  if (!id) {
    return alert('아이디를 입력하세요')
  } else if (!comment) {
    return alert('댓글을 입력하세요')
  }

  try {
    await axios.post('/comments/insert', {
      id,
      comment
    })
    getcomments()
  } catch (err) {
    console.log(err)
  }

  e.target.userid.value = ''
  e.target.comment.value = ''

})



async function getcomments(req, res, next) {
  try {
    const result = await axios.get(`/comments`)
    const comments = result.data
    const tbody = document.querySelector('#comment_list tbody')
    tbody.innerHTML = ''

    comments.map((comment) => {
      const row = document.createElement('tr')

      let td = document.createElement('td')
      td.textContent = comment.id // 댓글번호
      row.appendChild(td)

      td = document.createElement('td')
      //td.textContent = comment.User.name
      td.textContent = comment.commenter
      row.appendChild(td)

      td = document.createElement('td')
      td.textContent = comment.comment
      row.appendChild(td)

      // 수정버튼
      const edit = document.createElement('button')
      edit.textContent = '수정'
      td = document.createElement('td') // td 생성
      td.appendChild(edit) // 버튼을 td에 추가
      row.appendChild(td) // 버튼이 든 td 를 tr에 추가
      edit.addEventListener('click', async (e) => {
        try {
          const newComment = prompt('바꿀 내용을 입력하세요')
          if (!newComment) {
            return alert('내용을 입력하세요')
          }
          // http://localhost:3000/comments/update/???
          await axios.patch('/comments/update/' + comment.id, { comment: newComment })
          getcomments()
        } catch (err) {
          console.error(err)
        }
      })

      // 삭제버튼
      const del = document.createElement('button')
      del.textContent = '삭제'
      td = document.createElement('td')
      td.appendChild(del)
      row.appendChild(td)
      tbody.appendChild(row)

      del.addEventListener('click', async (e) => {
        try {
          const result = confirm('삭제하시겠습니까?')
          if (result) {
            await axios.delete('/comments/delete/' + comment.id)
          }
          getcomments()
        } catch (error) {
          console.error(error)
        }
      })
    })
  } catch (error) {
    console.error(error)
  }
}


