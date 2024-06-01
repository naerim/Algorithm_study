function solution(num_str) {
    let answer = 0;
    ""+num_str.split("").forEach(v => answer += Number(v));
    return answer
}