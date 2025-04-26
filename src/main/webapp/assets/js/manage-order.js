document.querySelectorAll(".delivery-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const orderNum = this.getAttribute("data-orderNum");

    const url = `http://localhost:8080/api/admin/order/delivery/${orderNum}`;
    const response = await fetch(
        url, {
          method: 'PUT'
        });

    if (response.ok) {
      alert("배송 완료 처리되었습니다..");
      window.location.reload();
    }
  });
});

document.querySelectorAll(".delete-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const orderNum = this.getAttribute("data-orderNum");

    const url = `http://localhost:8080/api/admin/order/delete/${orderNum}`;
    const response = await fetch(
        url, {
          method: 'DELETE'
        });

    if (response.ok) {
      alert("취소 처리 되었습니다.");
      window.location.reload();
    }
  });
});

document.addEventListener('DOMContentLoaded', function() {
  var elems = document.querySelectorAll('.collapsible');
  var instances = M.Collapsible.init(elems, options);
});