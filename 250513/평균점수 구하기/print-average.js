
const fs = require("fs")

let scores = fs.readFileSync(0).toString().trim().split(" ").map(Number)


let sum = 0;

scores.forEach((score)=>{
    sum+=score; 
})

let avg = sum/8
console.log(avg.toFixed(1)); 