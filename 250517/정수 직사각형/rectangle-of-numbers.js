const fs = require("fs")


let [n,m] = fs.readFileSync(0).toString().trim().split(" ").map(Number)
let result = [] 
let cnt  = 1; 
for(let i=0; i<n; i++){
    let row = [] 
    for(let j=0; j<m; j++){
        row.push(cnt); 
        cnt++; 
    }
    result.push(row);
}

result.forEach((row)=>{
    console.log(row.join(" "))
})