function solution(num_list) {
    let plus = 0
    let mul = 1
    
    num_list.forEach(v => {
        mul *= v
        plus += v
    })
    
    return mul < plus*plus ? 1 : 0;
}