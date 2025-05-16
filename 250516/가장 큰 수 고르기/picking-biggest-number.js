const fs = require("fs")
const MIN = Number.MIN_SAFE_INTEGER;

let numbers = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let result = MIN;

numbers.forEach((number)=>{
    if(number>result){
        result = number; 
    }
})

console.log(result)
