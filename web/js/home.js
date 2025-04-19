var left = document.querySelector(".left");
var right = document.querySelector(".right");
var imglist = document.querySelector(".imglist");
var box = document.querySelector("#box");
var dots = document.querySelectorAll(".btnlist li");
var imgWidth = 500;
var time = 1000;
var steps = 50;
var interval = 20;
var current_red = 0;
var isMoving = false;
var autoId;
box.addEventListener("mouseenter", function (e) {
    left.style.opacity = 1;
    right.style.opacity = 1;
    clearInterval(autoId);
});
box.addEventListener("mouseleave", function (e) {
    left.style.opacity = 0;
    right.style.opacity = 0;
    autoMove();
});
function move(e, direction) {
    if (isMoving) {
        return;
    }
    isMoving = true;
    var start_x = imglist.offsetLeft;
    var end_x;
    if (typeof direction === "number") {
        end_x = direction;
        var delta_x = end_x - start_x;
    } else {
        var delta_x = direction === "left" ? imgWidth : -imgWidth;
        end_x = start_x + delta_x;
    }
    var step_dis = delta_x / steps;
    var next_inter_id = setInterval(function () {
        var current_x = imglist.offsetLeft;
        current_x += step_dis;
        imglist.style.left = current_x + "px";
        if (current_x === end_x) {
            if (current_x === 0) {
                imglist.style.left = -2000 + "px";
            } else if (current_x === -2500) {
                imglist.style.left = -500 + "px";
            }
            clearInterval(next_inter_id);
            changeDots(current_x);
            isMoving = false;
        }
    }, interval);
}
right.addEventListener("click", function (e) {
    move(e, "right");
});
left.addEventListener("click", function (e) {
    move(e, "left");
});
function changeDots(current_x) {
    var index = current_x / -500 - 1;
    index = index === -1 ? 3 : index === 4 ? 0 : index;
    dots[current_red].className = "";
    dots[index].className = "current";
    current_red = index;
}
for (var i = 0; i < dots.length; i++) {
    dots[i].setAttribute("data-index", i);
    dots[i].onclick = function (e) {
        var index = this.dataset.index;
        var target_pos = -imgWidth * (Number(index) + 1);
        move(e, target_pos);
    };
}
function autoMove() {
    autoId = setInterval(function () {
        move("right");
    }, 3000);
}
autoMove();