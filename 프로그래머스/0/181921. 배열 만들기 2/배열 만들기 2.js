function solution(l, r) {
    var answer = [];
    for(let i=l; i<=r; i++) {
        const str = ""+i
        if(str.split("").every(v=>v==="0"||v==="5")) answer.push(+str)
    }
    return answer.length ? answer : [-1];
}