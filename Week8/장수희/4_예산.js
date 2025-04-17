const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

// const input = ["4", "120 110 140 150", "485"];
// const input = ["5", "70 80 30 40 100", "450"];
// const input = ["3", "1 3 5", "8"];
// const input = ["3", "30 20 10", "31"];
// const input = ["4", "101 101 101 101", "400"];

const N = input[0];
const budget = input[1].split(" ").map(Number);
const total = input[2];

let start = 1;
let end = Math.max(...budget);
let answer = 0;

while (start <= end) {
  const mid = Math.floor((start + end) / 2);
  let count = 0;
  for (let i = 0; i < budget.length; i++) {
    if (budget[i] > mid) {
      count += mid;
    } else {
      count += budget[i];
    }
  }
  if (count <= total) {
    answer = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}
console.log(answer);
