function solution(arr) {
    for(let i=1; i<=arr.length; i++) {
        const new_arr = arr.map(v => {
            if(v >= 50 && v%2===0) return v/2
            else if(v<50 && v%2===1) return v*2+1
            else return v
        })
        if(JSON.stringify(arr) === JSON.stringify(new_arr)) {
            return i-1
        } else arr = new_arr
    }
    return 0;
}