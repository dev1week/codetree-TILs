
const fs = require("fs")

let n = fs.readFileSync(0).toString().trim().split(" ").map(Number)

for(let i=0; i<n; i++){
    for(let j=0; j<n; j++){
        let result = i+1+n*(j);
        process.stdout.write(result+" ")
    }
    process.stdout.write("\n")
}