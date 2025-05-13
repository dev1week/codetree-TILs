const fs = require("fs")

let arr = fs.readFileSync(0).toString().trim().split(" ")

console.log(arr.reverse().join(""));