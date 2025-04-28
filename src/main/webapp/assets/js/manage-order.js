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
    const data = await response.json();

    if (data.data) {
      alert("배송 완료 처리되었습니다.");
      window.location.href = "http://localhost:8080/admin/order/list"
    }
    else{
      alert("문제가 발생하였습니다.");
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

    const data = await response.json();

    if (data.data) {
      alert("취소 처리 되었습니다.");
      window.location.href = "http://localhost:8080/admin/order/list"
    }
    else{
      alert("문제가 발생하였습니다.")
    }
  });
});

document.addEventListener('DOMContentLoaded', function() {
  var elems = document.querySelectorAll('.collapsible');
  var instances = M.Collapsible.init(elems, options);
});