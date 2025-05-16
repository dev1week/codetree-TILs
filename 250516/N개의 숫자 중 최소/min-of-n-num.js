const fs = require("fs")

const MAX = Number.MAX_SAFE_INTEGER; 
let [n, input] = fs.readFileSync(0).toString().trim().split("\n")
let numbers = input.split(" ").map(Number)
let result = MAX; 
let cnt = 0; 

numbers.forEach((number)=>{
    if(number<result){
        result = number; 
        cnt = 0; 
    }

    if(number===result){
        cnt++; 
    }
})


console.log(result+" "+cnt);