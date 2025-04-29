const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

// const input = ["2 3", "1 2 4", "8 16 32", "3", "1 1 2 3", "1 2 1 2", "1 3 2 3"];

const [N, M] = input[0].split(" ").map(Number);

const inputArr = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

const resultArr = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

for (let i = 1; i <= N; i++) {
  const row = input[i].split(" ").map(Number);
  for (let j = 1; j <= M; j++) {
    inputArr[i][j] = row[j - 1];
    resultArr[i][j] =
      inputArr[i][j] +
      resultArr[i - 1][j] +
      resultArr[i][j - 1] -
      resultArr[i - 1][j - 1]; //누적합 공식 !!
  }
}

const K = Number(input[N + 1]);

for (let k = 0; k < K; k++) {
  const [i, j, x, y] = input[N + 2 + k].split(" ").map(Number);
  const result =
    resultArr[x][y] -
    resultArr[i - 1][y] -
    resultArr[x][j - 1] +
    resultArr[i - 1][j - 1];

  console.log(result);
}
