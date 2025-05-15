let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let arr = Array(10)

arr[0] = input[0]
arr[1] = input[1]

for(let i=2; i<10; i++){
    arr[i] = (arr[i-1]+arr[i-2])%10;
}

console.log(arr.join(" "))

