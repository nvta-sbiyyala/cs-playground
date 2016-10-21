const Text = require("./text_utils");
const Number = require("./number_utils");

const text = new Text("Javascript ES6");
console.log(text.highlight("ES6"));

const n = new Number();
console.log(n.findPrime(10));
