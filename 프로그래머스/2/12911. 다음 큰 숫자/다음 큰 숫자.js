function solution(n) {
    
    const num = n.toString(2).split("").filter(v => v==="1").length
    
    let index = n+1
    while(true) {
        const new_num = index.toString(2).split("").filter(v => v==="1").length
        if(new_num === num) {
            return index
        }
        index++
    }
}