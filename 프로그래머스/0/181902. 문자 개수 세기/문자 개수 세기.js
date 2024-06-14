function solution(my_string) {
    const arr = new Array(52).fill(0)
    my_string.split("").forEach(v => {
        if(v>="a" && v<="z") {
            arr[v.charCodeAt(0) - "a".charCodeAt(0) + 26]++
        } else if(v>="A" && v<="Z") {
            arr[v.charCodeAt(0) - "A".charCodeAt(0)]++
        }
    })
    return arr;
}