const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n")[0];

// const input = "AECF";
const alphabet = {
  A: 3,
  B: 2,
  C: 1,
  D: 2,
  E: 3,
  F: 3,
  G: 3,
  H: 3,
  I: 1,
  J: 1,
  K: 3,
  L: 1,
  M: 3,
  N: 3,
  O: 1,
  P: 2,
  Q: 2,
  R: 2,
  S: 1,
  T: 2,
  U: 1,
  V: 1,
  W: 2,
  X: 2,
  Y: 2,
  Z: 1,
};

let num = input.split("").map((char) => alphabet[char]);

//배열이 1개 될 때까지 반복
while (num.length > 1) {
  const next = [];
  for (let i = 0; i < num.length; i += 2) {
    const a = num[i];
    let b;
    if (i + 1 < num.length) {
      b = num[i + 1];
    } else {
      b = 0;
    }

    let sum = a + b;
    if (sum > 10) sum %= 10;
    next.push(sum);
  }
  num = next;
}

const final = num[0];
if (final % 2 === 1) {
  console.log("I'm a winner!");
} else {
  console.log("You're the winner?");
}
