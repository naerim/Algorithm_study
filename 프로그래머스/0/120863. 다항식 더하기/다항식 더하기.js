function solution(polynomial) {
    var answer = '';
    let x = 0;
    let num = 0;
    polynomial.split(" ").filter(v => v!=="+").map(v => {
        if(v.includes("x")) {
           if(v==="x") {
               x += 1
           } else {
               x += Number(v.split("x")[0])
           }
        } else num += Number(v)
    })
    
    if (x !== 0) {
        answer += (x === 1 ? "x" : x + "x");
    }
    if (num !== 0) {
        if (x !== 0) {
            answer += " + ";
        }
        answer += num;
    }
    
    if (answer === "") {
        answer = "0";
    }
    
    return answer;
}