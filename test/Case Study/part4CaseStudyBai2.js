function part4CaseStudyBai2() {
    let strings = prompt("Nhập vào đây một chuỗi cần kiểm tra");
    let arr = Array();
    for (let i = 0; i < strings.length ; i++) {
        arr[i] = strings[i];
    }
    for (let i = 0; i < arr.length ; i++) {
        let check = 0;
        for (let j = 0; j < arr.length ; j++) {
            if (arr[i] === arr[j] && i !== j) {
                check++;
                arr.splice(j,1);
                j--;
            }
        }
        // if (check > 0) {
        //     arr.splice(i,1);
        //     i--;
        // }
    }
    alert("DifferentSymbolsNaise(s) :" + arr.length + ". Phần tử khác nhau là :" + arr);
}