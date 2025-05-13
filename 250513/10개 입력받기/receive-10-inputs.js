let fs = require("fs")

let numbers = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let sum = 0;
let cnt = 0; 

for(let number of numbers){
    if(number==0) break;
    sum += number; 
    cnt++;
}
let avg = (sum/cnt).toFixed(1);
console.log(sum+" "+avg)