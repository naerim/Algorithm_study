function solution(myString, pat) {
    let answer = 0
    myString.split("").forEach((v,i) => {
        if(v===pat[0]) {
            if(myString.slice(i, i+pat.length) === pat) {
                answer++
            }
        }
    })
    return answer;
}