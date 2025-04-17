const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

// const input = ["5", "6 3 2 10 -10", "8", "10 9 -5 2 3 4 5 -10"];
const N = Number(input[0]);
const M = Number(input[2]);
const cardNum = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
const targets = input[3].split(" ").map(Number);

const result = [];

const binary = (arr, target) => {
  let start = 0;
  let end = arr.length - 1;

  while (start <= end) {
    const mid = Math.floor((start + end) / 2);
    if (arr[mid] === target) return true;
    else if (arr[mid] > target) end = mid - 1;
    else start = mid + 1;
  }
  return false;
};

for (let i = 0; i < targets.length; i++) {
  if (binary(cardNum, targets[i])) {
    result.push(1);
  } else {
    result.push(0);
  }
}

console.log(result.join(" "));
