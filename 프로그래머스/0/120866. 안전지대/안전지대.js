function solution(board) {
    const n = board.length
    const dx = [-1, 0, 1, 1, 1, 0, -1, -1]
    const dy = [-1, -1, -1 ,0, 1, 1, 1, 0]
    
    board.forEach((arr,i) => arr.forEach((v, j) => {
        if(v===1) {
            for(let k=0; k<8; k++){
                const nx = i + dx[k]
                const ny = j + dy[k]
                if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]===0) board[nx][ny] = 2
            }
        }
        return v
    }))

    return board.flat().filter(v => v===0).length
}