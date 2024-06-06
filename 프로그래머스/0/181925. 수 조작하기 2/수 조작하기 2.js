function solution(numLog) {
    var answer = '';
    numLog.forEach((v,i) => {
        if(i !== 0) {
            switch(v - numLog[i-1]) {
                case 1: 
                    answer += "w"
                    break
                case -1:
                    answer += "s"
                    break
                case 10:
                    answer += "d"
                    break
                case -10:
                    answer += "a"
                    break
            }
        }
    })
    return answer;
}