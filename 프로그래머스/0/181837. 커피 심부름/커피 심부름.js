function solution(order) {
    let answer = 0;
    order.forEach(v => {
        if(v.includes("americano") || v === "anything") {
            answer += 4500
        } else if (v.includes("cafelatte")) {
            answer += 5000
        }
    })
    return answer;
}