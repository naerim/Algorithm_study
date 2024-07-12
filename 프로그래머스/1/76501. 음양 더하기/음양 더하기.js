function solution(absolutes, signs) {
    let answer = 0;
    signs.forEach((v,i) => {
        v ? answer +=absolutes[i] : answer -=absolutes[i]
    })
    return answer;
}