function toggleDropdown() {
    document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        for (var i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

function formatPrice(value) {
    const numberValue = parseFloat(value);
    return numberValue.toLocaleString('vi-VN') + 'đ';
}

const priceElements = document.querySelectorAll('.formatprices');
priceElements.forEach(element => {
    const giaValue = element.textContent.trim();
    element.textContent = formatPrice(giaValue);
});

function logoutcheck() {
    confirm("bạn có chắc muốn đăng xuất?")
}


const hoverDanhMuc = document.getElementById('hoverdanhmuc');
const danhMucList = document.querySelector('.formhoverdanhmuc');

hoverDanhMuc.addEventListener('mouseenter', function () {
    danhMucList.style.display = 'block';
});

hoverDanhMuc.addEventListener('mouseleave', function () {
    setTimeout(function () {
        if (!danhMucList.matches(':hover')) {
            danhMucList.style.display = 'none';
        }
    }, 200);
});

danhMucList.addEventListener('mouseenter', function () {
    danhMucList.style.display = 'block';
});

danhMucList.addEventListener('mouseleave', function () {
    danhMucList.style.display = 'none';
});

// Handle hover for "Thương Hiệu" button
const hoverThuongHieu = document.getElementById('hoverthuonghieu');
const thuongHieuList = document.querySelector('.formhoverthuonghieu');

hoverThuongHieu.addEventListener('mouseenter', function () {
    thuongHieuList.style.display = 'block';
});

hoverThuongHieu.addEventListener('mouseleave', function () {
    setTimeout(function () {
        if (!thuongHieuList.matches(':hover')) {
            thuongHieuList.style.display = 'none';
        }
    }, 200);
});

thuongHieuList.addEventListener('mouseenter', function () {
    thuongHieuList.style.display = 'block';
});

thuongHieuList.addEventListener('mouseleave', function () {
    thuongHieuList.style.display = 'none';
});