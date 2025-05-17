const fs = require("fs")

let numbers = fs.readFileSync(0).toString().trim().split(" ").map(Number)


let result = [Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER ];

numbers.forEach((number)=>{
    if(number<500&&number>result[0]){
        result[0] = number; 
    }

    if(number>500&&number<result[1]){
        result[1] = number;
    }
})

console.log(result.join(" "))
