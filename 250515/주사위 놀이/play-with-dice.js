let fs = require("fs")

let logs = fs.readFileSync(0).toString().trim().split(" ").map(Number)


let cnts = Array(7).fill(0)

logs.forEach((log)=>{
    cnts[log]++; 
})


for(let num=1; num<=6; num++){
    console.log(num+" - "+cnts[num])
}


