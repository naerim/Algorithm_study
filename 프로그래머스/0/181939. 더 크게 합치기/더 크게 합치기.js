function solution(a, b) {
    let first = parseInt(a + "" + b)
    let second = parseInt(b + "" + a)
    
    return first > second ? first : second;
}