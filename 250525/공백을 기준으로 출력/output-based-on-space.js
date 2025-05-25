const fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let result = ""
input.forEach((s)=>{
    for(let i=0; i<s.length; i++){
        if(s[i]!==" "){
            result+=s[i]
        }
    }
})

console.log(result);