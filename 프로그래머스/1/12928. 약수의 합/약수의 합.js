function solution(n) {
    var answer = 0;
    let i=n
    while(i>=1) {
        if(n%i===0) answer += i
        i--
    }
    return answer;
}