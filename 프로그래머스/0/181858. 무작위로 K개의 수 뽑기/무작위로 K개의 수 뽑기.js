function solution(arr, k) {
    let answer = [];
    let count = 0;
    for(let i=0; i<arr.length; i++) {
        if(count === k) break;
        if(answer.includes(arr[i])) continue
        else {
            answer.push(arr[i])
            count++
        }
    }
 
    const remain = k-answer.length
    for(let i=0; i<remain; i++) answer.push(-1)
    return answer;
}