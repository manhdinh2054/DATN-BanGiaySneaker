
window.addEventListener("DOMContentLoaded",function (){



    const values = document.getElementById("valueSL");
    document.getElementById("tangSL").addEventListener("click", function(){
        values.value = parseInt(values.value)+1;
    });
    document.getElementById("giamSL").addEventListener("click", function(){
        if(values.value>1){
            values.value = parseInt(values.value)-1;
        }
    });
})


function checkvali() {
    let checkboxes = document.querySelectorAll('.selectsss');
    const sanphamaddbtn = document.getElementById("submitaddsp");

    let isChecked = false;
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            isChecked = true;
        }
    });
    if (isChecked) {
        sanphamaddbtn.disabled = false;
        sanphamaddbtn.className = "btn btn-primary";
    } else {
        sanphamaddbtn.className = "btn btn-secondary";
        sanphamaddbtn.disabled = true;
    }
}

function formatPrice(value) {
    const numberValue = parseFloat(value);
    return numberValue.toLocaleString('vi-VN') + 'đ';
}

const priceElements = document.querySelectorAll('.giasp111');
priceElements.forEach(element => {
    const giaValue = element.textContent.trim();
    element.textContent = formatPrice(giaValue);
});




const rows = document.querySelectorAll("#tablesss tbody tr");
let tong = 0;
rows.forEach(function(row) {
    const soluong = parseInt(row.querySelector(".soluongsp111").textContent.trim());

    const giaspText = row.querySelector(".giasp111").textContent.trim();
    const giasp = parseInt(giaspText.replace(/\D/g, ''));

    if (!isNaN(soluong) && !isNaN(giasp)) {
        const tonggia = giasp * soluong;
        tong += tonggia;
    }
    document.getElementById("tongtien111").textContent = tong;
});

function khachTra1111(){
    const khachtra1 = document.getElementById("khachtra").value;
    document.getElementById("khachtra111").textContent = khachtra1;

    const tongtien1 = parseInt(document.getElementById("tongtien111").textContent.trim());
    document.getElementById("tongtien1").value = tongtien1;
    console.log(tongtien1)
    console.log(khachtra1)

    if (!isNaN(tongtien1) && !isNaN(khachtra1)) {

        const tong = tongtien1 - khachtra1;
        document.getElementById("soTienThanhToan111").textContent = tong;
    } else {

        document.getElementById("soTienThanhToan111").textContent = "0";
    }



}



document.addEventListener("DOMContentLoaded", function() {
    const buttonthanhtoan = document.getElementById("btntienmat");
    const buttonchuyenkhoan = document.getElementById("btnchuyenkhoan");
    const displaytienmat = document.querySelector(".displayloaithanhtoantienmat");
    const displaychuyenkhoan = document.querySelector(".displaylaoithanhtoanchuyenkhoan");
    displaychuyenkhoan.style.display = "none";
    buttonthanhtoan.addEventListener("click", function(event) {
        event.preventDefault();
        displaytienmat.style.display = "block";
        displaychuyenkhoan.style.display = "none";
    });
    buttonchuyenkhoan.addEventListener("click", function(event) {
        event.preventDefault();
        displaytienmat.style.display = "none";
        displaychuyenkhoan.style.display = "block";
    });
});


document.getElementById("searchsanpham").addEventListener("keyup", function() {
    const filter = this.value.toLowerCase();
    const table = document.getElementById("tablesanpham111");
    const rows = table.getElementsByTagName("tr");
   for (let i = 1; i < rows.length; i++) {
       const a = rows[i].getElementsByTagName('td');
       let f = false;
       for (let j = 0; j < a.length; j++) {
           const ab = a[j];
           if(ab.textContent.toLowerCase().indexOf(filter)>-1){
               f = true;
               break;
           }
       }
       if(f){
           rows[i].style.display = "";
       }else {
           rows[i].style.display = "none";
       }
   }

});

function filterProducts() {
    // Get the selected values from the dropdowns
    const categoryFilter = document.getElementById('locsanphamdanhmuc').value;
    const brandFilter = document.getElementById('locsanphamhang').value;
    const colorFilter = document.getElementById('locsanphammausac').value;

    // Get all rows of the table
    const rows = document.querySelectorAll('#tablesanpham111 tbody tr');

    rows.forEach(row => {
        const category = row.cells[7].innerText;
        const brand = row.cells[6].innerText;
        const color = row.cells[4].innerText;

        // Check conditions for filtering
        const matchesCategory = categoryFilter === "all" || category === categoryFilter;
        const matchesBrand = brandFilter === "all" || brand === brandFilter;
        const matchesColor = colorFilter === "all" || color === colorFilter;

        // Show or hide the row based on matches
        if (matchesCategory && matchesBrand && matchesColor) {
            row.style.display = ""; // Show row
        } else {
            row.style.display = "none"; // Hide row
        }
    });
}


