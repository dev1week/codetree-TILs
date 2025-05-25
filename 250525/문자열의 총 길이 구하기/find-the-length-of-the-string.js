const fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split(" ")

let result = 0; 
input.forEach((s)=>{
    result += s.length; 
})

console.log(result);