const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

// const input = ["4 11", "802", "743", "457", "539"];

const [K, N] = input[0].split(" ");
const lines = input.slice(1).map(Number);

let start = 1;
let end = Math.max(...lines);
let answer = 0;

while (start <= end) {
  const mid = Math.floor((start + end) / 2);

  let count = 0; //최대 랜선 길이
  for (let i = 0; i < lines.length; i++) {
    count += Math.floor(lines[i] / mid);
  }
  if (count >= N) {
    answer = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}

console.log(answer);
