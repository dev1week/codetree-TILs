const fs = require("fs")


let input = fs.readFileSync(0).toString().trim().split("\n")

for(let i=3; i>=0; i--){
    console.log(input[i]);
}