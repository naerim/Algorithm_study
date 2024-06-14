function solution(my_string, queries) {
    queries.forEach(([s,e]) => {
        const change = my_string.slice(s, e+1).split("").reverse().join("")
        const first = my_string.slice(0, s)
        const end = my_string.slice(e+1)
        my_string = first + change + end
    })
    return my_string;
}