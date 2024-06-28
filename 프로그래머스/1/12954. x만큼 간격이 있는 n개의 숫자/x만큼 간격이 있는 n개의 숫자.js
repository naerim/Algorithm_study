function solution(x, n) {
    var answer = [];
    let r = x
    for(let i=1; i<=n; i++) {
        answer.push(x)
        x+=r
    }
    return answer;
}