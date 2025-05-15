let fs = require("fs")


let input = fs.readFileSync(0).toString().trim().split("\n")

let a = input[1].split(" ").map(Number)
let b = input[2].split(" ").map(Number)


let finalResult = false; 
for(let i=0; i<a.length; i++){
    let result = true; 
    for(let j=0; j<b.length; j++){
        //console.log(a[i+j]+" "+b[j])
        if(a[i+j]!=b[j]){
            result = false; 
            break;
        }
    }

    if(result) finalResult = true; 
}

console.log(finalResult?"Yes":"No"); 