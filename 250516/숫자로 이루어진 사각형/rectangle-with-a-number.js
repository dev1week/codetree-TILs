const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const N = Number(input[0]);
// Please write your code here.

let result = ""
function numberSquare(n){
    let number = 1; 
    for(let i=0; i<n; i++){
        for(let j=0; j<n; j++){
            if(number===10){
                number = 1; 
            }
            result += number; 
            result += " "
            number++; 
        }
        result += "\n"
    }
}


numberSquare(N)
console.log(result); 