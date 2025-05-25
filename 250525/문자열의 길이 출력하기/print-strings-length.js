const fs = require("fs")

let string = fs.readFileSync(0).toString().trim().split("\n")

console.log(string[0].length+string[1].length);