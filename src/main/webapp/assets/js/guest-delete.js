
document.querySelectorAll(".delete-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const orderNum = this.getAttribute("data-orderNum");

    const url = `http://localhost:8080/api/member/order/delete/${orderNum}`;
    const response = await fetch(
        url, {
          method: 'DELETE'
        });

    const data = await response.json();

    if (data.data) {
      alert("취소 처리 되었습니다.");
      window.location.href = "http://localhost:8080/member/guest"
    }
    else{
      alert("문제가 발생하였습니다.")
    }
  });
});
