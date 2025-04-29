const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const n = input[0];
const x = input[1].split(" ").map(Number);

let result = 0;
let sum = x[0]; //배열 첫 번째 원소 항상 0으로 초기화하기!!

for (let i = 1; i < n; i++) {
  result += x[i] * sum;
  sum += x[i];
}
console.log(result);
