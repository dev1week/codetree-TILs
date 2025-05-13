let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let n = Number(input[0])

let winner = 0; 
for(let scoresInput of input.slice(1)){
    let scores = scoresInput.split(" ").map(Number); 

    let sum = 0;
    scores.forEach((e)=>{
        sum+=e;
    }); 

    let avg = (sum/4).toFixed(1); 
    
    if(avg>=60){
        winner++;
        console.log("pass");
    }else{
        console.log("fail");
    }
}

console.log(winner); 