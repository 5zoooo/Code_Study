const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const N = input[0];
const M = input[1];
const arr = input[2].split(" ").map(Number);

arr.sort((a, b) => a - b);

let start = 0;
let end = N - 1;
let count = 0;

while (start < end) {
  const sum = arr[start] + arr[end];

  if (sum < M) {
    start++;
  } else if (sum == M) {
    count++;
    start++;
    end--;
  } else {
    end--;
  }
}

console.log(count);
