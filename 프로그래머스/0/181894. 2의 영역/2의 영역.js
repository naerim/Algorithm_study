function solution(arr) {

    let first = -1, last = -1
    
    for(let i=0; i<arr.length; i++) {
        if (arr[i]===2) {
            first = i
            break
        }
    }
    for(let i=arr.length-1; i>=0; i--) {
        if (arr[i]===2) {
            last = i
            break
        }
    }
    
    if(first === -1) {
        return [-1]
    } else if (first === last) {
        return [2]
    } else {
        return arr.slice(first, last+1)
    }
}