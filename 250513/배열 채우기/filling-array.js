const fs = require("fs")

let numbers = fs.readFileSync(0).toString().trim().split(" ")

let results = []
for(let number of numbers){
    if(number==0) break; 
    results.push(number); 
}

console.log(results.reverse().join(" ")); 