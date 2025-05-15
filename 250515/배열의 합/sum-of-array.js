let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let arr = [] 

for(let i=0; i<4; i++){
    arr.push(input[i].split(" ").map(Number));
}

for(let i=0; i<4; i++){
    let sum = 0; 
    arr[i].forEach((e)=>{
        sum+=e;
    })
    console.log(sum); 
}