let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")


let alphabets = [] 


for(let i=0; i<5; i++){
    alphabets.push(input[i].split(" "))
}

let diff = 'A'.charCodeAt(0)-'a'.charCodeAt(0)


for(let i=0; i<5; i++){
    for(let j=0; j<3; j++){
        alphabets[i][j]=String.fromCharCode(alphabets[i][j].charCodeAt(0)+diff); 
    }
    console.log(alphabets[i].join(" "))
}

