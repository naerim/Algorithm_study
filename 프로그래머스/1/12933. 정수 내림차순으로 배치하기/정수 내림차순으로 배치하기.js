function solution(n) {
    return +(n.toString().split("").map(v => +v).sort((a,b) => b-a).join(""));
}