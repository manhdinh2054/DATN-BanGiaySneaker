
function disablekhuyenmai(id) {
    const check = confirm("bạn có chắc muốn dừng khuyến mại này?");
    if (check == true) {
        fetch("/admin/quanlikhuyenmai/stopkhuyenmai/" + id, {
            method: 'POST',
        })
            .then(respone => {
                if(!respone.ok){
                    console.error('error',respone.statusText);
                    alert("Dừng khuyến mại thất bại");
                }
            }).catch(error =>{
                console.error('error', error);
                alert("Có lỗi xảy ra");
            })
        }else {
        return;
    }
    }



