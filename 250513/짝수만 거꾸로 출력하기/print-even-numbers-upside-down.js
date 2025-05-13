let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let n = Number(input[0])
let numbers = input[1].split(" ").map(Number)

let result = []
for(let number of numbers){
    if(number%2==0){
        result.push(number)
    }
}

console.log(result.reverse().join(" ")); 