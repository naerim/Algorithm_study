function solution(maps) {
    let answer = 0
    let n = maps.length
    let m = maps[0].length
    
    // (n-1,m-1) 도착
    // 방문 배열
    let visited = new Array(n).fill(false).map(v => new Array(m).fill(false))
    let direction = [{x:1,y:0}, {x:-1,y:0}, {x:0,y:1}, {x:0,y:-1}]
    
    // 큐
    let queue = []
    // 출발지
    queue.push({x:0, y:0, move: 1})
    visited[0][0] = true
    
    while(queue.length > 0) {
        let q = queue.shift()

        if(q.x === n-1 && q.y === m-1) return q.move
        
        direction.map((v) => {
            let nx = q.x + v.x
            let ny = q.y + v.y

            if(nx>=0&&nx<=n-1&&ny>=0&&ny<=m-1&&!visited[nx][ny]&&maps[nx][ny]===1) {
                visited[nx][ny] = true
                queue.push({x:nx, y:ny, move: q.move + 1})
            }
        })
    }
    
    return -1;
}