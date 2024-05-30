function solution(my_string, index_list) {
    var answer = '';
    index_list.forEach(v => {
        answer += my_string[v]
    })
    return answer;
}