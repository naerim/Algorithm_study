function solution(num_list) {
    return num_list.length >= 11 ? num_list.reduce((acc,v) => acc+v) : num_list.reduce((acc,v) => acc*v)
}