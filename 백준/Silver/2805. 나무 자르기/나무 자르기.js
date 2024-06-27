let fs = require("fs");
// "/dev/stdin"
// "./text.txt"
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const [n, m] = input[0].split(" ").map((v) => +v);
const arr = input[1].split(" ").map((v) => +v);
arr.sort((a, b) => a - b);

let left = 0;
let right = arr[n - 1];
let answer = 0;

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let sum = 0;
  arr.forEach((v) => {
    if (v >= mid) sum += v - mid;
  });

  if (sum >= m) {
    // 더한값이 m보다 클때
    // 더 높은 절단기로도 자를 수 있는 가능성 있음
    if (mid > answer) answer = mid;
    left = mid + 1;
  } else {
    // 더한값이 m보다 작을때
    right = mid - 1;
  }
}

console.log(answer);
