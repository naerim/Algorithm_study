function solution(picture, k) {
    var answer = [];
    picture.forEach(str => {
        for(let i=0; i<k; i++) answer.push(str.split("").map(v => v.repeat(k)).join(""))
    })
    return answer;
}