function solution(my_string) {
    let answer = []
    const len = my_string.length
    for(let i=0; i<len; i++) {
        answer.push(my_string.slice(i))
    }
    return answer.sort();
}