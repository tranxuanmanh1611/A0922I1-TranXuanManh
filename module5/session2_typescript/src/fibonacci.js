var findFibonacci = function (ordinalNumber) {
    if (ordinalNumber == 1 || ordinalNumber == 2) {
        return 1;
    }
    return findFibonacci(ordinalNumber - 1) + findFibonacci(ordinalNumber - 2);
};
var fibonacciSize = 10;
var sumFibonacci = 0;
for (var i = 1; i <= fibonacciSize; i++) {
    sumFibonacci += findFibonacci(i);
}
console.log("the sum of 10 first fibonacci is: " + sumFibonacci);
