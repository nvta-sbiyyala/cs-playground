/*
 * This function can be invoked any number of times with integer parameters,
 *  it is only when it is invoked with no parameters that the sum is returned; 
 */
module.exports = {
  sum: function(...elems) {
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
}
