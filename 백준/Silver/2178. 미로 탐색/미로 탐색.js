let fs = require("fs");
// "/dev/stdin"
// "./text.txt"
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let [N, M] = input.shift().split(" ").map(Number);
const arr = input.map((v) => v.split("").map(Number));

const bfs = () => {
  let queue = [];
  let dx = [0, 1, 0, -1];
  let dy = [1, 0, -1, 0];
  let visited = Array.from(Array(N), () => Array(M).fill(false));

  queue.push({ x: 0, y: 0, cnt: 1 });
  visited[0][0] = true;

  while (queue.length > 0) {
    let q = queue.shift();

    if (q.x === N - 1 && q.y === M - 1) {
      return q.cnt;
    }
    for (let i = 0; i < 4; i++) {
      let nx = q.x + dx[i];
      let ny = q.y + dy[i];
      if (
        nx >= 0 &&
        nx < N &&
        ny >= 0 &&
        ny < M &&
        !visited[nx][ny] &&
        arr[nx][ny]
      ) {
        visited[nx][ny] = true;
        queue.push({ x: nx, y: ny, cnt: q.cnt + 1 });
      }
    }
  }
};

console.log(bfs());
