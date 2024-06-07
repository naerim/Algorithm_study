function solution(board, k) {
    var answer = 0;
    board.map((arr,i) => arr.map((v,j) => {
        if(i+j <= k) {
            answer += v
        }
    }))
    return answer;
}