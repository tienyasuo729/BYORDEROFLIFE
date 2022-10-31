function part4CaseStudyBai1() {
    let something = prompt("Nhập vào đây một chuỗi nào đó");
    let arr = Array();
    let print = "";

    for (let i = 0; i < something.length; i++) {
        arr[i] = something[i];
    }
    for (let i = 0; i < arr.length ; i++) {
        if (arr[i] === " " && arr[i+1] === " " && i >0 && i < arr.length-1  ) {
            arr.splice(i, 1);
        }
    }
    for (let i = 0; i < arr.length; i++) {
        if (arr[0] !== " ") {
            arr[0] = arr[0].toUpperCase();
        }
        if (arr[i] === " ") {
            arr[i + 1] = arr[i + 1].toUpperCase();
        }
        print += arr[i];
    }
    alert(print);
}