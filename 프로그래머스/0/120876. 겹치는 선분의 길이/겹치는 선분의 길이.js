function solution(lines) {
    let answer = Array(200).fill(0)
    
    lines.forEach((arr,i) => {
        for(let j=arr[0]; j<arr[1]; j++) {
            answer[j+100] += 1
        }
    })

    return answer.filter(v => v>=2).length;
}