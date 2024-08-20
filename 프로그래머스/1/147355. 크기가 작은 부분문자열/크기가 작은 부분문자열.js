function solution(t, p) {
    var answer = 0;
    const pLength = p.length;
    const pNum = Number(p);

    for(let i = 0; i <= t.length - pLength; i++) {
        const new_str = t.slice(i, i + pLength);
        const num = Number(new_str);
        if(num <= pNum) {
            answer++;
        }
    }
    return answer;
}