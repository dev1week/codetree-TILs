

const fs = require("fs")


let[ n,m] = fs.readFileSync(0).toString().trim().split(" ").map(Number)

let result = Array(n).fill(0).map(()=>Array(m).fill(0))

let cnt = 0; 
for(let i=0; i<m; i++){
    //짝수 열일 경우 증가 
    if(i%2==0){
        for(let j=0; j<n; j++){
            result[j][i] = cnt; 
            cnt++; 
        }
    }else{
        for(let j=n-1; j>=0; j--){
            result[j][i] = cnt; 
            cnt++; 
        }
    }
}

for(let i=0; i<n; i++){
    console.log(result[i].join(" "))
}