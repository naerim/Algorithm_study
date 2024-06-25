function solution(n) {
    var answer = -1;
    let i = 1
    while(i**2 <= n) {
        if(i**2 === n) {
            answer = i+1
            break
        }
        i++;
    }
    return answer !== -1 ? answer**2 : -1;
}