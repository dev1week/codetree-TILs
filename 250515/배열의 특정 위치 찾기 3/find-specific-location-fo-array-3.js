let fs = require("fs")

let arr = fs.readFileSync(0).toString().trim().split(" ").map(Number)

for(let i=0; i<arr.length; i++){
    if(arr[i]==0){
        console.log(arr[i-1]+arr[i-2]+arr[i-3])
        break;
    }
}