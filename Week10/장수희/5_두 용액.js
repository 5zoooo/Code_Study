const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const N = Number(input[0]);
const arr = input[1].split(" ").map(Number);

arr.sort((a, b) => a - b);

let start = 0;
let end = N - 1;

let min = Infinity;
let answer = [];

while (start < end) {
  const sum = arr[start] + arr[end];

  if (Math.abs(sum) < min) {
    min = Math.abs(sum);
    answer = [arr[start], arr[end]];
  }

  // 0보다 작으면 더 큰 수 쓰기 ->  start++
  if (sum < 0) {
    start++;
  }
  // 0보다 크면 더 작은 수 쓰기 -> end--
  else {
    end--;
  }
}

console.log(answer[0], answer[1]);
