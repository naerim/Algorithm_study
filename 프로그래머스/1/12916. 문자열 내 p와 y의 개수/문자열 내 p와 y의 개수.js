function solution(s){
    let p_num = 0, y_num = 0
    s.split("").map(v => v.toLowerCase()).forEach(v => {
       if(v==="p") p_num+=1
        if(v==="y") y_num+=1
    })

    return p_num === y_num
}