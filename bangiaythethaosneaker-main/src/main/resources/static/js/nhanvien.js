const optionsmenu = document.querySelector('.mainmenuoption');
const submenu = document.querySelector('.submenu');
const changeicon = document.getElementById('btnchange');
const submenu1 = document.querySelector('.submenu1');
const changeicon1 = document.getElementById('btnchange1');
const iconname = ['fa-solid fa-angle-down fa-spin fa-2xs', 'fa-solid fa-angle-right fa-spin fa-spin-reverse fa-2xs']
const iconsss = document.getElementById('dmms')
const iconsss1 = document.getElementById('dmms1')
let numbericon = 0;
let numbericon1 = 0;
changeicon.addEventListener('click', function () {
    numbericon = (numbericon + 1) % iconname.length;
    iconsss.className = iconname[numbericon];
    submenu.style.display = submenu.style.display === 'none' ? 'block' : 'none';

});
changeicon1.addEventListener('click', function () {
    numbericon1 = (numbericon1 + 1) % iconname.length;
    iconsss1.className = iconname[numbericon1];
    submenu1.style.display = submenu1.style.display === 'none' ? 'block' : 'none';
})

document.addEventListener("DOMContentLoaded",function (){
    const modalform = document.getElementById("Modal-form");
    const btnOpen = document.getElementById("openmodal");
    const btnClose = document.getElementById("closeModal");

    btnOpen.onclick = function () {
        modalform.style.display = "block";

    }
    btnClose.onclick = function () {
        modalform.style.display = "none";
    }
    window.onclick = function (event) {
        if (event.target == modalform) {
            modalform.style.display = "none";
        }
    }
})
document.addEventListener("DOMContentLoaded",function (){
    const modalform = document.getElementById("Modal-form");
    const btnOpen = document.getElementById("openmodal");
    const btnClose = document.getElementById("closeModal");

    btnOpen.onclick = function () {
        modalform.style.display = "block";

    }
    btnClose.onclick = function () {
        modalform.style.display = "none";
    }
    window.onclick = function (event) {
        if (event.target == modalform) {
            modalform.style.display = "none";
        }
    }
})


window.onload = function () {
    const message = document.getElementById('successMessage').value;
    if (message !== null) {
        toastr.success(message, 'Thành Công!', {possitionClass: 'toast-top-right'})
    }
}

window.onload = function () {
    const addvaluess = document.getElementById('successadd').value;
    if (addvaluess !== null) {
        toastr.success(addvaluess, 'Thành Công!', {possitionClass: 'toast-top-right'})
    }
}

window.onload = function () {
    const deletevalues = document.getElementById('successMessageDelete').value;
    if (deletevalues !== null) {
        toastr.success(deletevalues, 'Thành Công!', {positionClass: 'toast-top-right'});
    }
}
window.onload = function (){
    const hoadon5 = document.getElementById('check5hoadon').value;
    if (hoadon5 !== null) {
        toastr.success(hoadon5, 'Thông báo', {positionClass: 'toast-top-right'});

    }
}

window.onload = function (){
    const httt = document.querySelectorAll(".hinhthucthanhtoan");
    httt.forEach(function (item) {
        if(item.textContent == "Tại quầy"){
            item.style.backgroundColor = "green";
            item.style.color = "black";
            item.style.borderRadius = "10px";
            item.style.textAlign = "center";

        }else {
            item.style.backgroundColor = "red";
            item.style.color = "black";
            item.style.borderRadius = "10px";
            item.style.textAlign = "center";
        }
    })
    const trangthai = document.querySelectorAll(".trangthaiform");
    trangthai.forEach(function (item) {
        if(item.textContent == "Đã thanh toán"){
            item.style.backgroundColor = "green";
            item.style.color = "black";
            item.style.borderRadius = "10px";
            item.style.textAlign = "center";

        }else if(item.textContent == "Đã hủy"){
            item.style.backgroundColor = "red";
            item.style.color = "black";
            item.style.borderRadius = "10px";
            item.style.textAlign = "center";
        }else {
            item.style.backgroundColor = "yellow";
            item.style.color = "black";
            item.style.borderRadius = "10px";
            item.style.textAlign = "center";
        }
    })
}
document.addEventListener("DOMContentLoaded", function(){
    const form1 = document.getElementById("qlhd1");
    const form2 = document.getElementById("qlhd2");
    const btn1 = document.getElementById("btn1");
    const btn2 = document.getElementById("btn2");
    btn1.onclick = function(){
        form1.style.display = "block";
        form2.style.display = "none";
    }
    btn2.onclick = function(){
        form1.style.display = "none";
        form2.style.display = "block";
    }

})


function previewImages(event) {
    const files = event.target.files;
    const imagePreviewContainer = document.getElementById('imagePreview');
    imagePreviewContainer.innerHTML = '';

    for (let i = 0; i < files.length; i++) {
        const file = files[i];
        const reader = new FileReader();

        reader.onload = function(e) {

            const imageContainer = document.createElement('div');
            imageContainer.style.display = 'inline-block';
            imageContainer.style.position = 'relative';
            imageContainer.style.margin = '10px';

            const img = document.createElement('img');
            img.src = e.target.result;
            img.style.maxWidth = '100px';
            img.style.maxHeight = '100px';


            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'X';
            deleteButton.style.position = 'absolute';
            deleteButton.style.top = '0';
            deleteButton.style.right = '0';
            deleteButton.style.background = 'red';
            deleteButton.style.color = 'white';
            deleteButton.style.border = 'none';
            deleteButton.style.cursor = 'pointer';
            deleteButton.onclick = function() {
                imageContainer.remove();
            };

            imageContainer.appendChild(img);
            imageContainer.appendChild(deleteButton);
            imagePreviewContainer.appendChild(imageContainer);
        };

        reader.readAsDataURL(file);
    }
}



