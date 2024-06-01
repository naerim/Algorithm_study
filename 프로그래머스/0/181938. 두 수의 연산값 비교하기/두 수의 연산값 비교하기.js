function solution(a, b) {
    let plus = a + "" + b
    let mul = 2 * a * b
    
    if(plus == mul) return Number(plus)
    
    return plus > mul ? Number(plus) : mul;
}