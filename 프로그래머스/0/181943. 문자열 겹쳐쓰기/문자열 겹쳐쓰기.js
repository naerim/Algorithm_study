function solution(my_string, overwrite_string, s) {
    const o_len = overwrite_string.length
    return my_string.substring(0,s) + overwrite_string + my_string.substring(s+o_len);
}