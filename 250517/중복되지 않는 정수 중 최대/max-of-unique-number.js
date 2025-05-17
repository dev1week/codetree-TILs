const fs = require("fs")
const MIN = Number.MIN_SAFE_INTEGER;
let cnt = Array(1001).fill(0); 

let [n, inputNumbers] = fs.readFileSync(0).toString().trim().split("\n"); 

let numbers = inputNumbers.split(" ").map(Number)
let result = MIN; 
numbers.forEach((number)=>{
    cnt[number]++;
    
})


for(let number=1; number<=1000; number++){
    if(cnt[number]===1&&result<number){
        result = number; 
    }
}

console.log(result===MIN?-1:result);
