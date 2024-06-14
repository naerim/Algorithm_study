function solution(arr) {
    const row_num = arr.length
    const col_num = arr[0].length
    
    if(row_num===col_num) return arr
    else if(row_num > col_num) {
        return arr.map((v_arr) => {
            let i=0
            while(i++ < row_num-col_num) v_arr.push(0)
            return v_arr
        })
    } else {
        let i=0
        while(i++ < col_num-row_num) arr.push(new Array(col_num).fill(0))
        return arr
    }
}