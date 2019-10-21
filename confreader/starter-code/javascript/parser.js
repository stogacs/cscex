const fs = require("fs"),
  path = require("path");

const filepath = path.join(__dirname, "conf-t1");

let buffer = fs.readFileSync(filepath);
let contents = buffer.toString();

function parse(s) {
  // Implementation here
  map = new Map();
  return map;
}
