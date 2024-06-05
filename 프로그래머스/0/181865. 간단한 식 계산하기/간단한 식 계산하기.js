function solution(binomial) {
    let answer = 0
    let [a, op, b] = binomial.split(" ")

    switch(op) {
        case "+":
            answer = parseInt(a)+parseInt(b)
            break
        case "-":
            answer = parseInt(a)-parseInt(b)
            break
        case "*":
            answer = parseInt(a)*parseInt(b)
            break
        default:
            answer = 0
    }
    return answer;
}