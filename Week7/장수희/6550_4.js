const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

for (let i = 0; i < input.length; i++) {
  const [s, t] = input[i].split(" ");

  let idx = 0;
  for (let j = 0; j < t.length; j++) {
    if (t[j] === s[idx]) {
      idx++;
    }
    if (idx === s.length) break;
  }
  console.log(idx === s.length ? "Yes" : "No");
}
