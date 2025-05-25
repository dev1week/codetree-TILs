const fs = require("fs")

let inputs = fs.readFileSync(0).toString().trim().split("\n")

let minLength = 21;
let maxLength = 0; 


inputs.forEach((string)=>{
    if(string.length>maxLength){
        maxLength = string.length;
    }

    if(string.length<minLength){
        minLength = string.length;
    }
    
})

//console.log(maxLength+" "+minLength)
console.log(maxLength-minLength);