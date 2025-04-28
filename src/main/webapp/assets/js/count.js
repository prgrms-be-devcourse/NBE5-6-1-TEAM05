const createOrder = data => {
  const clone = document.querySelector('#coffeeCartListTemplate').firstElementChild.cloneNode(true);
  const coffeeName = clone.querySelector('.coffee-name');
  const coffeeCountJs = clone.querySelector('.coffee-count');
  const deleteBtn = clone.querySelector('.delete-btn');

  coffeeName.textContent = data.name;
  coffeeCountJs.textContent = data.coffeeCount;

  coffeeCountJs.setAttribute("data-coffeeId", data.id);
  deleteBtn.setAttribute("data-coffeeId", data.id);
  clone.setAttribute("data-coffeeId", data.id);

  clone.removeAttribute("id");
  clone.style.display = "flex";

  deleteBtn.addEventListener("click", async function(event) {
    event.preventDefault();
    const coffeeId = this.getAttribute("data-coffeeId");
    const url = `http://localhost:8080/api/delete/${coffeeId}`;
    const response = await fetch(
        url, {
          method:'DELETE'
        });
    console.log(response);

    const coffeeLi = this.closest('.coffee-li');
    if (coffeeLi) coffeeLi.remove();
  });

  return clone;
}

document.querySelectorAll(".add-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const coffeeId = this.getAttribute("data-coffeeId");
    const url = `http://localhost:8080/api/add/${coffeeId}`;
    const response = await fetch(
        url,{
          method:'PUT'
        });
    const data = await response.json();
    const coffeeCart = data.data;

    if(coffeeCart===null){
      alert("재고가 부족하여 이 이상 담을 수 없습니다.")
      return;
    }

    const exist = document.querySelector(`.coffee-list`)
    const e = exist.querySelector(`.coffee-count[data-coffeeId="${coffeeId}"]`);

    // 커피 아이디가 없으면 생성 있으면 개수 +1
    if(e!==null){
      e.textContent = (coffeeCart.coffeeCount+"개");
    }else{
      const clone = createOrder(coffeeCart);
      document.querySelector('.coffee-list').appendChild(clone);
    }
  });
});


document.querySelectorAll(".sub-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function(event) {
    event.preventDefault();
    const coffeeId = this.getAttribute("data-coffeeId");
    const exist = document.querySelector(`.coffee-list`)
    const coffeeLi = exist.querySelector(`.coffee-li[data-coffeeId="${coffeeId}"]`);
    const count = exist.querySelector(`.coffee-count[data-coffeeId="${coffeeId}"]`);

    console.log(exist);
    console.log(coffeeLi);

    if(count===null)
    {
      return;
    }

    const url = `http://localhost:8080/api/sub/${coffeeId}`;
    const response = await fetch(
        url,{
          method:'PUT'
        });
    const data = await response.json();
    const coffeeCart = data.data;


    if(!coffeeCart){
      coffeeLi.remove();
      return;
    }
    count.textContent = (coffeeCart.coffeeCount+"개");
  });
});

