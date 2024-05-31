function solution(num_list) {

    const num = num_list.length
    
    if(num_list[num-1] - num_list[num-2] > 0) {
        num_list.push(num_list[num-1] - num_list[num-2])
    } else {
        num_list.push(num_list[num-1]*2)
    }
    
    return num_list
    ;
}