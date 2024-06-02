function solution(arr1, arr2) {
    let num1 = arr1.length
    let num2 = arr2.length
    
    if(num1 === num2) {
        let sum1 = arr1.reduce((acc, v) => acc + v, 0)
        let sum2 = arr2.reduce((acc, v) => acc + v, 0)    
        
        if (sum1 === sum2) return 0
        return sum1 > sum2 ? 1 : -1
    } else {
        return num1 > num2 ? 1 : -1
    }
}