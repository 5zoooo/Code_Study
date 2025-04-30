const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const A = input[1].split(" ").map(Number);
const B = input[2].split(" ").map(Number);

let i = 0;
let j = 0;
const arr = [];

while (i < N && j < M) {
  if (A[i] < B[j]) {
    arr.push(A[i]);
    i++;
  } else {
    arr.push(B[j]);
    j++;
  }
}

while (i < N) {
  arr.push(A[i]);
  i++;
}

while (j < M) {
  arr.push(B[j]);
  j++;
}

console.log(arr.join(" "));
