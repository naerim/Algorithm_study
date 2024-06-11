function solution(arr) {
    let num = 1
    while (num < arr.length) num *= 2
    
    let value = num - arr.length
    while(value-- > 0) {
        arr.push(0)
    }
    return arr;
}