window.onload = function() {
    const check = document.querySelectorAll('.valitrangthaikhuyenmai');
    const values = document.getElementById("valuesss").value;
    check.forEach(function(element) {
        if (values == "true") {
            element.classList.add('show');
            element.style.textAlign = 'center';
            element.style.backgroundColor = "green";
        } else {
            element.classList.add('show');
            element.style.textAlign = 'center';
            element.style.backgroundColor = " red";
        }
    });
}


