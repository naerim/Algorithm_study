function solution(intStrs, k, s, l) {
    var answer = [];
    intStrs.forEach(v => {
        const num = parseInt(v.slice(s, s+l))
        if(num > k) answer.push(num)
    })
    return answer;
}