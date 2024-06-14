function solution(q, r, code) {
    var answer = '';
    code.split("").forEach((v,i) => {
        if(i%q===r) answer += v
    })
    return answer;
}