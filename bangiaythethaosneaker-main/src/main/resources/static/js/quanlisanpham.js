function deleteSanPhamChiTiet(id) {
    const check = confirm("Bạn có chắc muốn xóa?");
    if (check == true) {
        fetch('/api/deletesanphamchitiet/' + id, {
            method: 'DELETE',
        }).then(response => {
            if (response.ok) {
                document.getElementById("sanpham111-" + id).remove();
            } else {
                console.error('Error:', response.statusText);
                alert("Xóa sản phẩm thất bại");
            }
        }).catch(error => {
            console.error('Fetch Error:', error);
            alert("có lỗi xảy ra")
        })
    } else {
        return;
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


function deleteSanPham(id) {
    const check = confirm("Bạn có chắc muốn xóa? Những mẫu sản phẩm liên quan cũng sẽ bị xóa!");
    if (check) {
        fetch('/api/deletesanpham/' + id, {
            method: 'DELETE',
        })
            .then(response => {
                if (response.ok) {
                    // Xóa sản phẩm khỏi danh sách
                    document.getElementById('sanphamds-' + id).remove();
                    alert("Xóa sản phẩm thành công!");
                } else {
                    switch (response.status) {
                        case 404:
                            alert("Sản phẩm không tồn tại.");
                            break;
                        case 500:
                            alert("Có lỗi xảy ra trên máy chủ. Vui lòng thử lại sau.");
                            break;
                        default:
                            alert("Xóa sản phẩm thất bại: " + response.statusText);
                            break;
                    }
                    console.error('Error:', response.statusText);
                }
            })
            .catch(error => {
                console.error('Fetch Error:', error);
                alert("Có lỗi xảy ra khi thực hiện yêu cầu xóa.");
            });
    } else {
        return;
    }
}

function xoaAnhSanPham(id){
    fetch('/api/deletesanphamanh/'+id, {
        method: 'DELETE',
    }).then(response => {
        if (response.ok) {
            document.getElementById('anhSanPham1h').remove();
        }
    })

}

function goBack() {
    window.location.href='/admin/quanlisanpham';
}

function fetchAndDisplayPDF(id) {
    fetch('/employee/muahangtaiquay/exportpdf/'+id)
        .then(response => response.blob())
        .then(pdfBlob => {
            const url = URL.createObjectURL(pdfBlob);
            window.open(url, '_blank');
        })
        .catch(error => console.error('Error fetching PDF:', error));
}
function fetchAndDisplayPDFAdmin(id) {
    fetch('/admin/muahangtaiquay/exportpdf/'+id)
        .then(response => response.blob())
        .then(pdfBlob => {
            const url = URL.createObjectURL(pdfBlob);
            window.open(url, '_blank');
        })
        .catch(error => console.error('Error fetching PDF:', error));
}

