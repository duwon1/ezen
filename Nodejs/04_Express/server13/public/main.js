
getBoard_list()

async function getBoard_list(page) {
    try {
        if (page == undefined) {
            page = 1
        }
        const result = await axios.get(`/boards/boardList/${page}`);
        const boards = result.data.boardList
        const paging = result.data.paging

        const tbody = document.querySelector('#board-list tbody');
        tbody.innerHTML = '';
        boards.map(async (board) => {
            const row = document.createElement('tr');
            let td = document.createElement('td');

            td.textContent = board.id;
            td.id = 'boardnum';
            row.appendChild(td); // 게시물 번호

            td = document.createElement('td');
            let tContent = board.subject;
            try {
                const result = await axios.get(`boards/replycnt/${board.id}`);
                const data = result.data;
                let cnt = data.cnt;
                if (cnt !== 0) {
                    tContent += `<span style="color:red;font-weight:bold">[${cnt}]</span>`;
                }
            } catch (error) {
                console.error(error);
            }
            td.innerHTML = tContent;
            row.appendChild(td); // 게시물 제목

            td = document.createElement('td');
            td.textContent = board.writer;
            td.id = 'writer';
            row.appendChild(td); // 작성자

            td = document.createElement('td');
            td.textContent = board.created_at.substr(0, 10);
            td.id = 'created_at';
            row.appendChild(td); // 작성일

            td = document.createElement('td');
            td.textContent = board.readCount;
            td.id = 'readCount';
            row.appendChild(td); // 조회수

            row.addEventListener(`click`, () => {
                location.href = `/boards/boardView/${board.id}`;
            });

            tbody.appendChild(row); // 완성된 행을 tbody에 추가
        });

        const pageArea = document.querySelector('#page');
        pageArea.innerHTML = '';

        if (paging.prev) {
            pageArea.innerHTML += `&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onClick="getBoard_list('${paging.beginPage - 1}')">◀</a>`
        }

        for (let i = paging.beginPage; i <= paging.endPage; i++) {
            pageArea.innerHTML += `&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onClick="getBoard_list('${i}')">${i}</a>`
        }

        if (paging.next) {
            pageArea.innerHTML += `&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" onClick="getBoard_list('${paging.endPage + 1}')">▶</a>`
        }

    } catch (err) {
        console.error(err);
    }
}



