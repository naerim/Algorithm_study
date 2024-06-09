function solution(my_string, s, e) {
    const mid = my_string.slice(s, e+1).split("").reverse().join("")
    return my_string.substring(0, s) + mid + my_string.substring(e+1)
}