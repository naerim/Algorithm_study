function solution(strArr) {

    let list = {}
    strArr.forEach(v => {
        list[v.length] = (list[v.length] || 0) + 1
    })

    return Math.max(...Object.values(list));
}