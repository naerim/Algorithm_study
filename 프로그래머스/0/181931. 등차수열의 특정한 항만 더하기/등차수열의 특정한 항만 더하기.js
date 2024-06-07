function solution(a, d, included) {
    var answer = 0;
    included.forEach((v,i) => {
        v ? answer += a + i*d : answer
    })
    return answer;
}