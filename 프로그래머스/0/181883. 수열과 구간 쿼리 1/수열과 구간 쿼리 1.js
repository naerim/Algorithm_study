function solution(arr, queries) {
    queries.forEach(q_arr => {
        const [start, end] = q_arr
        for(let i=start; i<=end; i++) {
            arr[i] += 1
        }
    })
    return arr
}