const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n");

const S = input[0];
const K = input[1];

let str = S.replace(/\d/g, "");
if (str.includes(K)) console.log(1);
else console.log(0);
