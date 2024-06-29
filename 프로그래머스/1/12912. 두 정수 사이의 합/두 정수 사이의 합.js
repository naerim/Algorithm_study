function solution(a, b) {
    var answer = 0;
    let first = a, last=b
    if(a>=b) {
        first = b
        last = a
    }
    for(let i=first; i<=last; i++) answer += i
    return answer;
}