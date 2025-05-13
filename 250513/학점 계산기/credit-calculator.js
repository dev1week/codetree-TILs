const fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let n = Number(input[0]); 

let arr = input[1].split(" ").map(Number); 

let sum = 0;

for(let e of arr){
    sum+=e; 
}
let avg = (sum/n).toFixed(1);
console.log(avg);
console.log(avg>=4.0?"Perfect":(avg<3.0?"Poor":"Good"));