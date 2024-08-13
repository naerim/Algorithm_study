function solution(s) {
    const len = s.length
    if (len===4 || len===6) {
        return s.split("").every(v => !isNaN(v));
    }
    return false;
}