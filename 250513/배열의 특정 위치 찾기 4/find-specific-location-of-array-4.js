const fs = require("fs")

let numbers = fs.readFileSync(0).toString().trim().split(" ").map(Number)


let cnt = 0;
let sum = 0;

for(number of numbers){
    if(number==0)break;
    if(number%2==0){
        cnt++;
        sum+=number;
    }
}

console.log(cnt+" "+sum); 