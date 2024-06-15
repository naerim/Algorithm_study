function solution(n) {
    let arr = new Array(n).fill(null).map(() => new Array(n).fill(0))
    
    const dx = [0, 1, 0, -1]
    const dy = [1,0,-1,0]

    let count = 1
    let x = 0;
    let y = 0;
    let dir = 0;
    
    while(count <= n**2) {
        arr[x][y] = count
        let nx = x+dx[dir]
        let ny = y+dy[dir]
        if(nx<0 || nx>=n || ny<0 || ny>=n || arr[nx][ny]) {
            dir = (dir+1)%4
            nx = x+dx[dir]
            ny = y+dy[dir]
        }
        x = nx
        y = ny
        count++
    }

    return arr;
}