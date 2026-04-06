
// 다이어리 내용을 비동기(fetch)로 불러와서 화면을 갈아끼우는 함수
function loadDiary(url = '/diary?ajax=true') {
  if (!url.includes('ajax=true')) {
    url += (url.includes('?') ? '&' : '?') + 'ajax=true';
  }

  fetch(url)
      .then(response => response.text())
      .then(html => {
        document.getElementById('notebook-content').innerHTML = html;

        // ★ 새로 추가된 스크롤 마법 ★
        // 만약 URL에 'd=' (날짜 파라미터)가 있어서 일기 목록이 열렸다면?
        if (url.includes('d=')) {
          // 화면에 뜬 다이어리 보드(목록)를 찾아서
          const board = document.querySelector('.diary-board');
          if (board) {
            // 그 위치로 부드럽게 스르륵 스크롤 이동!
            board.scrollIntoView({ behavior: 'smooth', block: 'start' });
          }
        }
      })
      .catch(error => console.error("다이어리 로드 실패:", error));
}