let fs = require("fs");
// "/dev/stdin"
// "./text.txt"
const [n, ...arr] = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = Number(n);
const list = arr.map((v) => v.split(" ").map((v) => +v));

let dp = Array(N + 1).fill(0);

// i번째 일했을 때 얻는 최대 수익
for (let i = 0; i < N; i++) {
  const [period, value] = list[i];
  // j는 상담이 가능한 모든 날짜
  for (let j = i + period; j < N + 1; j++) {
    if (dp[j] < dp[i] + value) dp[j] = dp[i] + value;
  }
}

console.log(dp[N]);
