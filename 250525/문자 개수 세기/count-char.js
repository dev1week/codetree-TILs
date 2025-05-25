const fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let cnt = 0; 
for(let i=0; i<input[0].length; i++){
    if(input[0][i]==input[1]){
        cnt++;
    }
}

console.log(cnt)
