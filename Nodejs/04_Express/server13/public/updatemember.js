document.getElementById(`memberUpdate`).addEventListener(`submit`, async (event) => {
    event.preventDefault();

    const userid = event.target.userid.value;
    const pwd = event.target.pwd.value;
    const name = event.target.name.value;
    const phone = event.target.phone.value;
    const email = event.target.email.value;

    if (!pwd) {
        return alert(`비밀번호를 입력하세요.`);
    }
    if (!name) {
        return alert(`이름을 입력하세요.`);
    }
    if (!phone) {
        return alert(`전화번호를 입력하세요.`);
    }
    if (!email) {
        return alert(`이메일을 입력하세요.`);
    }
    try {
        await axios.post(`/members/update`, {userid, pwd, name, phone, email});
        location.href = `/boards`;
    } catch (error) {
        console.error(error);
    }
});