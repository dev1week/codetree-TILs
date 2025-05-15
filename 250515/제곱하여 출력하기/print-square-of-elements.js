
let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")


let n = Number(input[0])

let arr = input[1].split(" ").map(Number)

let result = ""
arr.forEach((e)=>{
    result += (e*e)+" "
})

console.log(result.trim())