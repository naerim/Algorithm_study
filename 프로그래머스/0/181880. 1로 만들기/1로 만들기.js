function solution(num_list) {
    var answer = 0;
    num_list.forEach(v => {
        while(v !== 1) {
            if(v%2===0) {
                v /= 2
            } else {
                v -= 1
                v /= 2
            }
            answer++
        }
    })
    return answer;
}