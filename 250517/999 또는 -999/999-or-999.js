const fs = require("fs")

const end1 = 999;
const end2 = -999; 

const MAX = Number.MAX_SAFE_INTEGER;
const MIN = Number.MIN_SAFE_INTEGER; 

let numbers = fs.readFileSync(0).toString().trim().split(" ").map(Number); 


let maxNum = MIN;
let minNum = MAX; 


for(let number of numbers){
    if(number===end1||number===end2){
        break; 
    }

    if(maxNum<number){
        maxNum = number; 
    }
    if(minNum>number){
        minNum = number; 
    }
}
let result = [maxNum, minNum];
console.log(result.join(" "))


