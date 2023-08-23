document.getElementById('write-form').addEventListener('submit', async (e) => {
  e.preventDefault();
  const subject = e.target.subject.value;
  const writer = e.target.userid.value;
  const text = e.target.text.value;

  if (!subject || !writer) {
    return alert('모든 내용을 입력하세요')
  }

  const formData = new FormData();
  formData.append('image', e.target.image.files[0]);
  formData.append('subject', subject);
  formData.append('writer', writer);
  formData.append('text', text);

  try {
    await axios.post('/boards/writeBoard', formData)
    location.href = '/boards'
  } catch (err) {
    console.error(err);
  }
})