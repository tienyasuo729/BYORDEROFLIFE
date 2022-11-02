// tiến dẻ rách
function part4CaseStudyBai2() {
    let strings = prompt("Nhập vào đây một chuỗi cần kiểm tra");
    let arr = Array();
    for (let i = 0; i < strings.length ; i++) {
        arr[i] = strings[i];
    }
    for (let i = 0; i < arr.length ; i++) {
        let check = 0;
        for (let j = 0; j < i ; j++) {
            if (arr[i] === arr[j]) {
                check++;
                arr.splice(j-1,1);
                j--;
            }
        }
        // if (check > 0) {
        //     arr.splice(i-1,1);
        //     i--;
        // }
    }
    alert(arr);
}

// nam đb
// function part4CaseStudyBai2() {
//     let strings = prompt("Nhập vào đây một chuỗi cần kiểm tra");
//     let arr = Array();
//     // for (let i = 0; i < strings.length; i++) {
//     //     arr[i] = strings[i];
//     // }
//     for (let i = 0; i < strings.length; i++) {
//         // let check = 0;
//         for (let j = 0; j < i; j++) {
//             if (arr[i] === arr[j]) {
//                 // check++;
//                 // arr.splice(j - 1, 1);
//                 // j--;
//                 arr.push(arr[i]);
//                 strings.splice(i, 1);
//                 break;
//             }
//         }
//         // if (check > 0) {
//         //     arr.splice(i-1,1);
//         //     i--;
//         // }
//     }
//     alert(arr);
// }