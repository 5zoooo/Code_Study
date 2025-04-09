const fs = require("fs");
const input = fs.readFileSync(0, "utf-8").trim().split("\n")[0];

let temp = [];
let output = "";
let isTag = false;

for (let i = 0; i < input.length; i++) {
  const char = input[i];
  if (input[i] === "<") {
    //태그 시작 전에 쌓인 단어 뒤집어서 출력
    output += temp.reverse().join("");
    temp = [];
    isTag = true;
    output += char;
  } else if (char === ">") {
    isTag = false;
    output += char;
  } else if (isTag) {
    // 태그 내부 그대로 출력
    output += char;
  } else if (char === " ") {
    // 단어 끝났으면 뒤집어서 출력 + 공백
    output += temp.reverse().join("") + " ";
    temp = [];
  } else {
    // 단어 저장
    temp.push(char);
  }
}
// 마지막 단어 남아있을 경우 처리
output += temp.reverse().join("");

console.log(output);
