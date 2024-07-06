function solution(n) {
    let answer = 0;
    let i=2;
    while(i<n) {
        if(n%i===1) {
            answer = i
            break;
        }
        i++
    }
    return answer;
}