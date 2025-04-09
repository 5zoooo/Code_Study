const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const [N, M] = input[0].split(" ").map(Number);
const neverHeard = new Set();
const neverSeen = [];
const neverHeardAndSeen = [];

for (let i = 1; i < N + 1; i++) {
  neverHeard.add(input[i]);
}
for (let i = N + 1; i < N + M + 1; i++) {
  neverSeen.push(input[i]);
}

for (const name of neverSeen) {
  if (neverHeard.has(name)) {
    neverHeardAndSeen.push(name);
  }
}

neverHeardAndSeen.sort();

console.log(neverHeardAndSeen.length);
for (let i = 0; i < neverHeardAndSeen.length; i++) {
  console.log(neverHeardAndSeen[i]);
}
