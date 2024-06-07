function solution(a, b, c) {


    let set = new Set([a,b,c])
    let size = set.size
    
    if(size === 3) {
        return a+b+c
    } else if(size === 1) {
        return (a+b+c)*(a**2+b**2+c**2)*(a**3+b**3+c**3)
    } else {
        return (a+b+c)*(a**2+b**2+c**2)
    }

}