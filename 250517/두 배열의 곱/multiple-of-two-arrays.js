const fs = require("fs")
let input = fs.readFileSync(0).toString().trim().split("\n")

let arr1 = []
let arr2 = []


for( let i=0; i<3; i++){
    arr1.push(input[i].split(" ").map(Number))
}

for(let i=0;i<3; i++){
    arr2.push(input[i+4].split(" ").map(Number))
}

for(let i=0; i<3; i++){
    for(let j=0; j<3; j++){
        let result = arr2[i][j]*arr1[i][j]
        process.stdout.write(result+" ")
    }
    process.stdout.write("\n")
}

