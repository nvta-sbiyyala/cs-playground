"use strict";

module.exports = function Number() {

  this.findPrime = n => {
    var primeNumbers = [2];
    var i = 3;
    
    while (primeNumbers.length < n) {
      if (isPrime(i)) {
	primeNumbers.push(i);
      }
      i++;
    }

    function isPrime(i) {
      const res = primeNumbers.every((prime) => {
	return !!(i % prime);
      });

      return res;
    }

    return primeNumbers;
  }
};
