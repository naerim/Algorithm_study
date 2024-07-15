const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = Number(input.shift());
input.shift();

let graph = Array.from(Array(N + 1), () => []);
input.forEach((v) => {
  const [start, end] = v.split(" ").map(Number);
  if (!graph[start]) graph[start] = [];
  if (!graph[end]) graph[end] = [];
  graph[start].push(end);
  graph[end].push(start);
});

const bfs = () => {
  let visited = new Array(N + 1).fill(false);
  let queue = [];
  queue.push(1);
  visited[1] = true;

  while (queue.length > 0) {
    const q = queue.shift();
    for (const cnt of graph[q]) {
      if (visited[cnt]) continue;
      queue.push(cnt);
      visited[cnt] = true;
    }
  }

  return visited.filter((v) => v).length - 1;
};

console.log(bfs());
