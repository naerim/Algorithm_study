function solution(num_list) {

    const [a,b] = num_list.slice(-2)
    return [...num_list, b-a>0 ? b-a : b*2]

}