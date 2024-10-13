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

const gia = document.getElementById("formatprices");
const formatprices = gia.textContent.trim();

function formatPrice(value) {
    const numberValue = parseFloat(value);
    return numberValue.toLocaleString('vi-VN') + 'đ';
}
gia.textContent = formatPrice(formatprices);

function logoutcheck() {
    confirm("bạn có chắc muốn đăng xuất?")
}


const minusButton = document.getElementById('button-minus');
const plusButton = document.getElementById('button-plus');
const inputField = document.getElementById('number-input');

minusButton.addEventListener('click', () => {
  
  
  const currentValue = parseInt(inputField.value);
  
  if (isNaN(currentValue) || currentValue <= 0) return;
  
  inputField.value = Math.max(1, currentValue - 1);

});

plusButton.addEventListener('click', () => {
  
  
  const currentValue = parseInt(inputField.value);

  if (isNaN(currentValue)) return;

  inputField.value = currentValue + 1;

});

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
