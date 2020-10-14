const fs = require("fs"),
  path = require("path");

const filepath: string = path.join(__dirname, "conf-t1");

let buffer: Buffer = fs.readFileSync(filepath);
let contents: string = buffer.toString();

function parse(s: string): Map<String, Object> {
  // Implementation here
  let map = new Map<String, Object>();
  return map;
}
