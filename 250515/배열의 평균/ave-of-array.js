let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let arr = [] 

for(let i=0; i<2; i++){
    arr.push(input[i].split(" ").map(Number))
}


let sum = 0; 
let cnt = 2*4; 
let rowSums =[]; 
let colSums= [];

for(let i=0; i<2; i++){
    let rowSum = 0; 
    for(let j=0; j<4; j++){
        sum+=arr[i][j]; 
        rowSum += arr[i][j]; 
    }
    rowSums.push((rowSum/4).toFixed(1)); 
}

for(let j=0; j<4; j++){
    let colSum = 0; 
    for(let i=0; i<2; i++){
        colSum += arr[i][j]; 
    }
    colSums.push((colSum/2).toFixed(1));
}

console.log(rowSums.join(" "))
console.log(colSums.join(" "))
console.log((sum/cnt).toFixed(1))
