function solution(left, right) {
    var answer = 0;
    for(let num=left; num<=right; num++) {
        let cnt = 2;
        for(let i=num; i>=1; i--) {
            if(num%i===0) cnt++
        }
        cnt%2===0 ? answer+=num : answer-=num;
    }
    return answer;
}