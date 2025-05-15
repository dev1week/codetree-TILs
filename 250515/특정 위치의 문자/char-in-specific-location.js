let fs = require("fs")

let arr = ['L', 'E', 'B', 'R', 'O','S']
let char = fs.readFileSync(0).toString().trim()

let idx = -1;
let resultIdx = -1; 
arr.forEach((e)=>{
    idx++; 
    if(e===char){
        resultIdx = idx;
    }
})


console.log(resultIdx===-1?"None":resultIdx); 