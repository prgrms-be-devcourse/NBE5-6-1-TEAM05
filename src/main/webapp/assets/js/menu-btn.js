document.querySelectorAll(".delete-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const coffeeId = this.getAttribute("data-coffeeId");

    const url = `http://localhost:8080/api/admin/menu/delete/${coffeeId}`;
    const response = await fetch(
        url, {
          method: 'DELETE'
        });
    if(response.data) {
      alert("삭제되었습니다.");
      window.location.reload();
    }
    else{
      alert("해당 상품 관련 주문을 처리한 후 삭제 가능합니다.")
    }
  });
});