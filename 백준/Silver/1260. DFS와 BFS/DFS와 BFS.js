let fs = require("fs");
// "/dev/stdin"
// "./text.txt"
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [N, M, V] = input
  .shift()
  .split(" ")
  .map((v) => +v);

let graph = Array.from(Array(N + 1), () => []);

input.map((v) => {
  const [start, end] = v.split(" ").map((v) => +v);
  if (!graph[start]) graph[start] = [];
  if (!graph[end]) graph[end] = [];
  graph[start].push(end);
  graph[end].push(start);
});

for (let i = 1; i <= N; i++) {
  graph[i].sort((a, b) => a - b);
}

// dfs
const dfs = () => {
  let dfs_ans = [];
  let visited = Array(N + 1).fill(false);

  const _dfs = (v) => {
    visited[v] = true;
    dfs_ans.push(v);
    for (const cur of graph[v]) {
      if (visited[cur]) continue;
      _dfs(cur);
    }
  };
  _dfs(V);

  return dfs_ans;
};

// bfs

const bfs = () => {
  let bfs_ans = [];
  let visited = Array(N + 1).fill(false);

  let queue = [];
  queue.push(V);
  visited[V] = true;

  while (queue.length > 0) {
    const q = queue.shift();
    bfs_ans.push(q);

    for (let cur of graph[q]) {
      if (visited[cur]) continue;
      queue.push(cur);
      visited[cur] = true;
    }
  }

  return bfs_ans;
};

console.log(dfs().join(" "));
console.log(bfs().join(" "));
