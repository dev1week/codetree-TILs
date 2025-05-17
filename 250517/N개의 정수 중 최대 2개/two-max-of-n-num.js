const fs = require("fs")
const MIN = Number.MIN_SAFE_INTEGER;
let [n, arrInput] = fs.readFileSync(0).toString().trim().split("\n"); 

let numbers = arrInput.split(" ").map(Number); 


let result1 = MIN;
let result2 = MIN; 

for(let number of numbers){
    if(number>=result1){
        result2 = result1; 
        result1 = number; 
    }else if(number>=result2){
        result2 = number; 
    }
    //result1보다 작거나 같은지 확인 
        //result2 = result1; 
        //작다면 result1 = number; 
}
console.log(result1+" "+result2);
