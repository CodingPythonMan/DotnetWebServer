export const Navbar = {
    Init: function () {
        let navUlLis = document.querySelectorAll("nav ul li");

        let excel_btn = document.querySelector(".excel_btn");
        let excel_show = document.querySelector("nav ul .excel_show");
        let excel_span = document.querySelector(".excel_span");

        let account_btn = document.querySelector(".account_btn");
        let account_show = document.querySelector("nav ul .account_show");
        let account_span = document.querySelector(".account_span");

        let inventory_btn = document.querySelector(".inventory_btn");
        let inventory_show = document.querySelector("nav ul .inventory_show");
        let inventory_span = document.querySelector(".inventory_span");

        let item_btn = document.querySelector(".item_btn");
        let item_show = document.querySelector("nav ul .item_show");
        let item_span = document.querySelector(".item_span");

        let chatting_btn = document.querySelector(".chatting_btn");
        let chatting_show = document.querySelector("nav ul .chatting_show");
        let chatting_span = document.querySelector(".chatting_span");

        [].forEach.call(navUlLis, function (navUlLi) {
            navUlLi.addEventListener("click", function () {
                var lis = this.parentNode.children;
                [].forEach.call(lis, function (li) {
                    li.classList.remove("active");
                });

                navUlLi.classList.add("active");
            });
        });

        excel_btn.addEventListener('click', function (e) {
            excel_show.classList.toggle('show');
            excel_span.classList.toggle('rotate');
            e.preventDefault();
        });
        
        account_btn.addEventListener('click', function (e) {
            account_show.classList.toggle('show');
            account_span.classList.toggle('rotate');
            e.preventDefault();
        });

        inventory_btn.addEventListener('click', function (e) {
            inventory_show.classList.toggle('show');
            inventory_span.classList.toggle('rotate');
            e.preventDefault();
        });

        item_btn.addEventListener('click', function (e) {
            item_show.classList.toggle('show');
            item_span.classList.toggle('rotate');
            e.preventDefault();
        });

        chatting_btn.addEventListener('click', function (e) {
            chatting_show.classList.toggle('show');
            chatting_span.classList.toggle('rotate');
            e.preventDefault();
        });
    }
}