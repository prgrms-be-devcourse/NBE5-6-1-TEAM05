const createOrder = data => {
  const clone = document.querySelector(
      '#coffeeCartListTemplate').firstElementChild.cloneNode(true);
  const coffeeId = clone.querySelector('.coffee-id');
  const coffeeName = clone.querySelector('.coffee-name');
  const coffeeCountJs = clone.querySelector('.coffee-count');

  coffeeId.textContent = data.id;
  coffeeName.textContent = data.name;
  coffeeCountJs.textContent = data.coffeeCount;
  return clone;
}

document.querySelectorAll(".add-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function() {
    const coffeeId = this.getAttribute("data-coffeeId");
    const url = `http://localhost:8080/api/add/${coffeeId}`;
    console.log("요청 URL:", url);
    const response = await fetch(
        url,{
          method:'PUT'
        });
    const data = await response.json();
    const coffeeCart = data.data;

    if(!coffeeCart){
      return;
    }

    const exist = document.querySelector(`.coffee-count[coffeeId="${coffeeId}"]`);

    // 커피 아이디가 없으면 생성 있으면 개수 +1
    if(exist){
      const coffeeCount = exist.querySelector('.coffee-count');
      coffeeCount.textContent = coffeeCart.coffeeCount;
    }else{
      const clone = createOrder(coffeeCart);
      document.querySelector('.coffee-list').appendChild(clone);
    }
  });
});

document.querySelectorAll(".sub-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function() {
    const coffeeId = this.getAttribute("data-coffeeId");
    const response = await fetch(
        `http://localhost:8080/api/sub/${coffeeId}`,{method:'PUT'});
    const data = await response.json();
    const exist = document.querySelector(`.coffee-count[coffeeId="${coffeeId}"]`);
    const count = exist.querySelector('.coffee-count');

    if(!data){
      count.remove();
      return;
    }
    const coffeeCart = data.data;


    // 커피 아이디가 없으면 무시 있으면 개수 -1
    if (exist) {
      count.textContent = coffeeCart.coffeeCount;
    }
  });
});

document.querySelectorAll(".delete-btn")
.forEach((btn) => {
  btn.addEventListener("click", async function() {
    const coffeeId = this.getAttribute("coffee-id");
    const response = await fetch(
        `http://localhost:8080/api/delete/${coffeeId}`,{method:'DELETE'});

    const exist = document.querySelector(`.delete-btn[coffeeId="${coffeeId}"]`);
    exist.remove()
  });
});