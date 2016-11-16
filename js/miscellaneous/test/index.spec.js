var expect = require('chai').expect
  , foo = 'bar'
  , beverages = { tea: [ 'chai', 'matcha', 'oolong' ] }
  , utils = require('../index.js');

const sum1 = utils.sum(1,2,3)();
const sum2 = utils.sum(1,2,3)(4)(5,6)();

expect(sum1).to.equal(6);
expect(sum2).to.equal(21);

expect(foo).to.be.a('string');
expect(foo).to.equal('bar');
expect(foo).to.have.length(3);
expect(beverages).to.have.property('tea').with.length(3);

function fiboClient(num) {
  for (num of utils.getFibonacci()) {
    if (num > 100) {
      break;
    }
    console.log(num);
  }
}

fiboClient(90);
