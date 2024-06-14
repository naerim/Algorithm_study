function solution(arr, queries) {
    var answer = [];
    queries.forEach(v => {
        let min = 1000001
        for(let i=v[0]; i<=v[1]; i++) {
            if(arr[i] > v[2]) min = Math.min(min, arr[i])
        }
        min===1000001 ? answer.push(-1) : answer.push(min)
    })
    return answer;
}