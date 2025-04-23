function addToCart() {
    const IdSanPham = document.getElementById("idSanPham").value;
    const soLuong = document.getElementById("number-input").value;
    const tenSanPham = document.getElementById("tenSanPham").textContent;
    const gia = document.getElementById("giaSanPham").value;
    const anhSanPham = document.getElementById("anhSanPham").value;

    const kichCo = document.querySelector("input[name=\"kichCo\"]:checked");
    if (!kichCo) {
        alert("Vui lòng chọn kích cỡ sản phẩm!");
        return;
    }
    if (soLuong <= 0) {
        alert("Vui lòng nhập số lượng hợp lệ!");
        return;
    }

    const kichCoValue = kichCo.value;

    fetch('/cart/addtodh', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            idSanPham: IdSanPham,
            soLuong: soLuong,
            kichCo: kichCoValue,
            tenSanPham: tenSanPham,
            anhSanPham: anhSanPham,
            gia: gia,


        }),
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert(data.message || "Thêm sản phẩm vào giỏ hàng thành công!");
            } else {
                alert(data.message || "Thêm sản phẩm vào giỏ hàng thất bại!");
            }
        })
        .catch(error => console.error('Lỗi:', error));
}



async function cartItemsGetsssss(){
    try{
        const res = await fetch("/sanpham/card/items",{
            method:'POST',
            credentials: 'same-origin',
            headers:{
                'Content-Type': 'application/json'
            }
        });
        if(!res.ok){
            throw new Error("không tìm thấy dữ liệu");
        }
        const items = await res.json();
        displayCartItems(items);
    }catch (error){
        console.error("Lỗi",error);
        document.getElementById('cart-items').innerText = 'Không có sản phẩm';
    }
}

function displayCartItems(cartItems) {
    const cartContainer = document.getElementById('cart-items');
    cartContainer.innerHTML = "";

    cartItems.forEach(item => {
        const itemDiv = document.createElement('div');
        itemDiv.classList.add('cart-item');
        itemDiv.innerHTML = `
                    <h3>${item.tenSanPham}</h3>
                    <p>Kích cỡ: ${item.kichCo}</p>
                    <p>Số lượng: ${item.soLuong}</p>
                    <p>Giá: ${item.gia}</p>
                `;
        cartContainer.appendChild(itemDiv);
    });
}
document.addEventListener('DOMContentLoaded', cartItemsGetsssss)


function thanhtoan(amout1,idDonHang){
    fetch("/pay/"+amout1+"/"+idDonHang)
        .then(response => response.text())
        .then(paymentUrl => {
            window.location.href = paymentUrl;
        })
        .catch(error => console.error("Lỗi khi lấy URL thanh toán:", error));
}

document.addEventListener("DOMContentLoaded",function (){
    var tongsotienthanhtoan = 0;

    const gia = document.querySelectorAll(".giasanpham");
    const soluong = document.querySelectorAll(".soluong");
    gia.forEach((giass, index) =>{
        const a = parseFloat(giass.value) || 0;
        const b = parseInt(soluong[index].value)||0;
        tongsotienthanhtoan += a*b;
    });
    document.getElementById("tongsotienthanhtoan").textContent = `Tổng giá: ${tongsotienthanhtoan.toLocaleString()} VND`
    document.getElementById("tongtienthanhtoan12").value =tongsotienthanhtoan;
    document.getElementById("thanhtoansssssd").addEventListener("click", function(){
        event.preventDefault();

        const hoVaTen = document.getElementById("hoVaTen").value;
        const sdtKhachHang = document.getElementById("sdtKhachHang").value;
        const diaChi = document.getElementById("diaChi").value;

        // Tạo formData để gửi đến server
        const formData = new FormData();
        formData.append("hoVaTen", hoVaTen);
        formData.append("sdtKhachHang", sdtKhachHang);
        formData.append("diaChi", diaChi);
        formData.append("tongtienthanhtoan12", tongsotienthanhtoan);


        fetch("/cart/addonhangtocartcheckout", {
            method: "POST",
            body: formData
        }).then(response => response.json())
            .then(data => {
                const idDonHang = data.idDonHang;
                thanhtoan(tongsotienthanhtoan, idDonHang);
            })
            .catch(error => {
                console.error("Lỗi khi xử lý thanh toán:", error);
                alert("Đã xảy ra lỗi. Vui lòng thử lại!");
            });

    });
})


