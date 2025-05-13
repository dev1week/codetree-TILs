const fs = require("fs")

let arr = fs.readFileSync(0).toString().trim().split(" ")


arr = arr.map((e)=>Number(e))

let sum = 0;
let cnt = 0;
for(let i=0; i<arr.length; i++){
    if(arr[i]>=250)break; 
    sum+=arr[i];
    cnt++;
}

console.log(sum +" "+sum/cnt);