const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");
// const input = ["4 7", "20 15 10 17"];

const [N, M] = input[0].split(" ").map(Number);
const height = input[1].split(" ").map(Number);

let start = 1;
let end = Math.max(...height);
let answer = 0;

while (start <= end) {
  const mid = Math.floor((start + end) / 2);
  let count = 0; //얻을 수 있는 총 나무 길이

  for (let i = 0; i < height.length; i++) {
    if (height[i] - mid > 0) {
      count += height[i] - mid;
    }
  }
  if (count >= M) {
    answer = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}
console.log(answer);
