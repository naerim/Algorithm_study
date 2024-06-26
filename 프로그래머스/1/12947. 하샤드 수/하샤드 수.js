function solution(x) {
    let answer = 0
    String(x).split("").forEach(v => answer += Number(v))

    return x%answer === 0 ? true : false
}