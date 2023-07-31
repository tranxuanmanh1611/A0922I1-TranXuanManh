var isPrime = function (numberToCheck) {
    var isPrime = true;
    if (numberToCheck < 2) {
        isPrime = false;
    }
    else {
        var countDividable = 0;
        for (var i = 1; i <= numberToCheck; i++) {
            if (numberToCheck % i == 0) {
                countDividable++;
            }
        }
        isPrime = countDividable <= 2;
    }
    return isPrime;
};
var numberArray = [1, 2, 3, 4, 5, 6];
var sumPrime = 0;
for (var i = 0; i < numberArray.length; i++) {
    if (isPrime(numberArray[i])) {
        sumPrime += numberArray[i];
    }
}
console.log("the sum of primes in this array is: " + sumPrime);
