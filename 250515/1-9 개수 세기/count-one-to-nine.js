let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")


let n = Number(input[0])

let arr = input[1].split(" ").map(Number)

let cnts = Array(9).fill(0)

arr.forEach((e)=>{
    cnts[e-1]++;
})

cnts.forEach((cnt)=>{
    console.log(cnt)
})


