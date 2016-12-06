var expect = require('chai').expect;

function sum_varargs(...args) {
  
  if (args.length === 2) {
    return args.reduce((a, b) => a+b, 0);
  } else if(args.length > 0) {
    return x => args[0]+x;
  } else {
    return -1;
  }
}

function sum(a, b) {
  
  if (b !== undefined) {
    return a+b;
  } else {
    return function(b) {
      return a+b;
    }
  }
}

expect(sum(5, 9)).to.equal(14);
expect(sum(5, 9)).to.equal(sum(5)(9));

expect(sum_varargs(5, 9)).to.equal(14);
expect(sum_varargs(5, 9)).to.equal(sum_varargs(5)(9));
