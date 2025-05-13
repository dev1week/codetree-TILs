const fs = require("fs")

let arr = fs.readFileSync(0).toString().trim().split(" ")

arr = arr.map(e=>Number(e)); 


let sumVal = 0;
arr.forEach((e)=>{
    sumVal+=e;
})

console.log(sumVal);