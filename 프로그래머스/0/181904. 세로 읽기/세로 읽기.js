function solution(my_string, m, c) {
    var answer = '';
    [...my_string].forEach((v,i) =>{
        if(i%m === c-1) {
            answer += v
        }
    })
    return answer;
}