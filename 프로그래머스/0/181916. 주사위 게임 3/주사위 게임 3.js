function solution(a, b, c, d) { 
    let arr = new Array(7).fill(0)
    
    Array(a,b,c,d).forEach((v) => arr[v]+=1)

    if(arr.includes(4)) {
        return 1111*arr.indexOf(4)
    } else if(arr.includes(3)) {
        return (10*arr.indexOf(3)+arr.indexOf(1))**2
    } else if(arr.includes(2)) {
        const set = new Set(arr)
        if(set.size===2) {
            const first = arr.indexOf(2)
            const last = arr.lastIndexOf(2)
            return (first+last)*Math.abs(first-last)
        } else return arr.indexOf(1)*arr.lastIndexOf(1)
    } else return arr.indexOf(1)
    

}