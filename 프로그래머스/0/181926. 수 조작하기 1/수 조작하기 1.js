function solution(n, control) {
    let answer = n;
    Array.from(control).forEach(v => {
        if(v==="w") answer++
        else if(v==="s") answer--
        else if(v==="d") answer += 10
        else if(v==="a") answer -= 10
    })
    return answer;
}