var expect = require('chai').expect;

/* function sum_varargs(...args) {
 *   
 *   if (args.length === 2) {
 *     return args.reduce((a, b) => a+b, 0);
 *   } else (args.length > 0) {
 *     return x => args[0]+x;
 *   }
 * }*/

function sum(a, b) {
  
  if (b !== undefined) {
    return a+b;
  } else {
    return function(b) {
      return a+b;
    }
  }
  
}

console.log(sum(5, 9));
console.log(sum(5)(9));

/* console.log(sum_varargs(5, 9));
 * console.log(sum_varargs(5)(9));*/
