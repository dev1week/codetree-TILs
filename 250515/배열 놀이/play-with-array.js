let fs = require("fs")

let input = fs.readFileSync(0).toString().trim().split("\n")

let nAndQ = input[0].split(" ").map(Number)

let n = nAndQ[0]
let q = nAndQ[1]


let numbers = input[1].split(" ").map(Number)


for(let i=0; i<q; i++){
    let query = input[2+i].split(" ").map(Number)
    
    let command = query[0];

    let a = query[1];

    if(command===1){
        console.log(numbers[a-1])
    }else if(command===2){
        let result = -1;

        for(let idx=0; idx<n; idx++){
            if(numbers[idx]===a){
                result = idx+1; 
                break
            }
        }

        console.log(result===-1?0:result)

    }else if(command==3){
        let e = query[2]
        console.log(numbers.slice(a-1,e).join(" "))
    }


}