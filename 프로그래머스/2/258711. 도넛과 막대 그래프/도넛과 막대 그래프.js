function solution(edges) {
    let map = new Map()
    
    // map 객체 생성
    for(let arr of edges) {
        if(!map.has(arr[0])) map.set(arr[0], [1,0])
        else {
            const [give, receive] = map.get(arr[0])
            map.set(arr[0], [give+1, receive])
        }
        if(!map.has(arr[1])) map.set(arr[1], [0,1])
        else {
            const [give, receive] = map.get(arr[1])
            map.set(arr[1], [give, receive+1])
        }

    }
    
    let answer = new Array(4).fill(0)
    for(const [key, value] of map) {
        const [give, receive] = value
        if(give >= 2 && receive===0) answer[0] = key
        else if(give===0) answer[2]++
        else if(give >= 2 && receive >= 2) answer[3]++
    }
    answer[1] = map.get(answer[0])[0] - answer[2] - answer[3]
    
    return answer;
}