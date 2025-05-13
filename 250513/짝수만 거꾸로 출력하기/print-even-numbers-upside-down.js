let fs = require("fs")

let numbers = fs.readFileSync(0).toString().trim().split("\n").map(Number)

let result = []
for(let number of numbers){
    if(number%2==0){
        result.push(number)
    }
}

console.log(result.reverse().join(" ")); 