const fs = require("fs")


let [nInput, input] = fs.readFileSync(0).toString().trim().split("\n")
let n = Number(nInput)
let prices = input.split(" ").map(Number)

let result = 0; 
for(let start=0; start<n-1; start++){
    for(let end = start+1; end<n; end++){
        
        let income = prices[end] - prices[start];
        if(income>result){
            result = income; 
        }
    }
}

console.log(result)