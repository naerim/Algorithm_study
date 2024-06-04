function solution(num_list, n) {
    const arr = num_list.splice(n)
    arr.push(...num_list)
    return arr;
}