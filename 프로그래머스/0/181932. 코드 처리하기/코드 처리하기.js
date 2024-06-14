function solution(code) {
    let answer = '';
    let mode = 0
    for(let i=0; i<code.length; i++) {
        if(mode) {
            if(code[i]==="1") mode = 0
            else if(i%2===1) answer+=code[i]
        } else {
            if(code[i]==="1") mode = 1
            else if(i%2===0) answer+=code[i]
        }
    }
    return answer.length ? answer : "EMPTY";
}