const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, X] = input[0].split(" ").map(Number);
const visit = input[1].split(" ").map(Number);

let start = 0;
let end = 0;
let count = 0;
let sum = 0;
let max = 0;

while (end < X) {
  sum += visit[end];
  end++;
}
max = sum;
count = 1;
end--;

while (end < N - 1) {
  end++;
  sum += visit[end];
  sum -= visit[start];
  start++;

  if (sum > max) {
    max = sum;
    count = 1;
  } else if (sum === max) {
    count++;
  }
}

if (sum === 0) {
  console.log("SAD\n");
} else {
  console.log(max + "\n" + count);
}
