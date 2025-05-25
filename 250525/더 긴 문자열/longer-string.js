const fs = require("fs")

let string = fs.readFileSync(0).toString().trim().split(" ")

if(string[0].length===string[1].length){
    console.log("same")
}else{
    console.log(string[0].length>string[1].length?string[0]+" "+(string[0].length+1):string[1]+" "+(string[0].length+1))
}

