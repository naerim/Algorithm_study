let fs = require("fs");
// "/dev/stdin"
// "./text.txt"
const [n, ...arr] = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = Number(n);
const list = arr.map((v) => v.split(" ").map((v) => +v));

let dp = Array(N).fill(0);

for (let i = 0; i < N; i++) {
  const [period, value] = list[i];
  if (i + period > N) continue;
  dp[i] += value;

  for (let j = i + period; j < N; j++) {
    dp[j] = Math.max(dp[i], dp[j]);
  }
}

console.log(Math.max(...dp));
