var expect = require('chai').expect
  , foo = 'bar'
  , beverages = { tea: [ 'chai', 'matcha', 'oolong' ] };

function sum(...elems) {

  let total = elems.slice();
  const add = (a, b) => a+b;
  
  return function _internalSum(...next) {
    if (next.length == 0) {
      return total.reduce(add, 0);
    }

    total = total.concat(next);
    return _internalSum;
  }
}

const sum1 = sum(1,2,3)();
const sum2 = sum(1,2,3)(4)(5,6)();

expect(sum1).to.equal(6);
expect(sum2).to.equal(21);

expect(foo).to.be.a('string');
expect(foo).to.equal('bar');
expect(foo).to.have.length(3);
expect(beverages).to.have.property('tea').with.length(3);
