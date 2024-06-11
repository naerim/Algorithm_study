function solution(arr, flag) {
    var answer = [];
    flag.forEach((v,i) => {
        let value = arr[i]
        if(v) {
            for(let i=0; i<value*2; i++) answer.push(value)
        } else {
            answer.splice(answer.length - value)
        }
    })
    return answer;
}