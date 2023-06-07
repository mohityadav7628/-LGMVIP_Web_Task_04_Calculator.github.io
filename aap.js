(function () {
  let screen = document.querySelector(".screen");
  let buttons = document.querySelectorAll(".btn");
  let clear = document.querySelector(".btn-clear");
  let equal = document.querySelector(".btn-equal");
  let percentageresult = document.querySelector(".percentageresult");
  let num = document.getElementById(".data-num");

  buttons.forEach(function (button) {
    button.addEventListener("click", function (e) {
      let value = e.target.dataset.num;
      screen.value += value;
    });
  });
  equal.addEventListener("click", function (e) {
    if (screen.value === "") {
      screen.value = "Please Enter";
    } else {
      let answer = eval(screen.value);
      screen.value = answer;
    }
  });
  clear.addEventListener("click", function (e) {
    screen.value = "";
  });
  percentageresult.addEventListener("click", function (e) {
// function percentage(){

  // let numone=(screen.value * 10)/100;
  screen.value = (screen.value * 10)/100;
// }
  // percentageresult.addEventListener("click", function (e) {
  });
})();
