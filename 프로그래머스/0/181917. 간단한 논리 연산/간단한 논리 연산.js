function solution(x1, x2, x3, x4) {
    return caculate(caculate(x1, x2, 0), caculate(x3, x4, 0), 1);
}

const caculate = (v1, v2, op) => {
    // op 0: 합집합, 1: 교집합
    if(op === 0) {
        return !v1 && !v2 ? false : true
    } else {
        return v1 && v2 ? true : false
    }
}