document.getElementById(`login-form`).addEventListener(`submit`, async (event) => {
    event.preventDefault();
    const userid = event.target.userid.value;
    const pwd = event.target.pwd.value;

    if (!userid) {
        return alert(`아이디를 입력하세요.`);
    }
    if (!pwd) {
        return alert(`패스워드를 입력하세요.`);
    }

    // 서버에 userid, pwd를 보내서 로그인 인증을 하고, 그 사용자의 모든 정보를 객체에 담아올 예정입니다.
    try {
        const result = await axios.post(`members/login`, {
            userid,
            pwd,
        });
        const member = result.data;
        const msg = document.getElementById(`msg`);
        if (member === null) {
            msg.innerHTML = `아이디가 없습니다.`;
        } else if (member.pwd !== pwd) {
            msg.innerHTML = `비밀번호가 맞지 않습니다.`;
        } else if (member.pwd === pwd) {
            location.href = `members/main`;
        } else {
            msg.innerHTML = `알 수 없는 이유로 로그인이 안되고 있습니다.`;
        }
    } catch (error) {
        console.error(error);
    }
    event.target.pwd.value = ``;
});