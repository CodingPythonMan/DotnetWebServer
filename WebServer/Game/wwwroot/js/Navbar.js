export const Navbar = {
    Init: function () {
        let navUlLis = document.querySelectorAll("nav ul li");

        let account_btn = document.querySelector(".account_btn");
        let account_show = document.querySelector("nav ul .account_show");
        let first = document.querySelector(".first");

        let inventory_btn = document.querySelector(".inventory_btn");
        let inventory_show = document.querySelector("nav ul .inventory_show");
        let second = document.querySelector(".second");

        let item_btn = document.querySelector(".item_btn");
        let item_show = document.querySelector("nav ul .item_show");
        let third = document.querySelector(".third");

        [].forEach.call(navUlLis, function (navUlLi) {
            navUlLi.addEventListener("click", function () {
                var lis = this.parentNode.children;
                [].forEach.call(lis, function (li) {
                    li.classList.remove("active");
                });

                navUlLi.classList.add("active");
            });
        });
        
        account_btn.addEventListener('click', function () {
           account_show.classList.toggle('show');
           first.classList.toggle('rotate');
        });

        inventory_btn.addEventListener('click', function () {
            inventory_show.classList.toggle('show');
            second.classList.toggle('rotate');
        });

        item_btn.addEventListener('click', function () {
            item_show.classList.toggle('show');
            third.classList.toggle('rotate');
        });
    }
}