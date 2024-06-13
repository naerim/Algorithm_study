function solution(arr, queries) {
    queries.forEach((v,i) => {
        for(let j=v[0]; j<=v[1]; j++) {
            if(j%v[2]===0) arr[j] += 1
        }
    })
    return arr;
}