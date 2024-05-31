function solution(num_list) {
    let odd = ""
    let even = ""
    
    num_list.forEach(v => {
        v % 2 === 0 ?  even += String(v) : odd += String(v)
    })
    
    
    return Number(even) + Number(odd);
}