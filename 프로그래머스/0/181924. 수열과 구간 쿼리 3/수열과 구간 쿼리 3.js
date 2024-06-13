function solution(arr, queries) {
    queries.forEach(v => {
        const temp = arr[v[0]]
        arr[v[0]] = arr[v[1]]
        arr[v[1]] = temp
    })
    return arr;
}