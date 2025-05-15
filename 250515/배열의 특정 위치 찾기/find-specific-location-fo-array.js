let fs = require("fs")

let arr = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let sum = 0
let sum1 = 0
let cnt = 0
for(let i=0; i<arr.length; i++){
    if(i%2==1){
        sum+=arr[i]
    }

    if((i+1)%3==0){
        sum1+=arr[i]
        cnt++
    }
}

let avg = (sum1/cnt).toFixed(1)

console.log(sum+" "+avg)