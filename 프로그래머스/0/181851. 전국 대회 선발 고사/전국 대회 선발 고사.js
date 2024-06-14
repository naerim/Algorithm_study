function solution(rank, attendance) {
    var answer = 0;
    
    let current_rank = 1
    let arr = [] // 참석 인원 배열
    
    while(arr.length < 3) {
        const index = rank.indexOf(current_rank)
        if(index !== -1 && attendance[index]) {
            arr.push(index)
        }
        current_rank++;
    }
    
    return 10000*arr[0] + 100*arr[1] + arr[2];
}