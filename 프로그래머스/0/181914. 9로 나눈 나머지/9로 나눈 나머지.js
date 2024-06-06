function solution(number) {
    return Array.from(number).reduce((acc,v) => acc+parseInt(v), 0) % 9;
}