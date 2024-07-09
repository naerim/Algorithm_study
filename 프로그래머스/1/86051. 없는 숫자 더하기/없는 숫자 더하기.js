function solution(numbers) {
    let arr = [0,1,2,3,4,5,6,7,8,9]
    return arr.filter(v => !numbers.includes(v)).reduce((v,acc)=> v + acc)
}