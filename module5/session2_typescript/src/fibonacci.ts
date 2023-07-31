const findFibonacci = (ordinalNumber: number): number => {
    if (ordinalNumber == 1 || ordinalNumber == 2) {
        return 1;
    }
    return findFibonacci(ordinalNumber - 1) + findFibonacci(ordinalNumber - 2);
}

let fibonacciSize: number = 10;
let sumFibonacci: number = 0;
for (let i = 1; i <= fibonacciSize; i++) {
    sumFibonacci += findFibonacci(i);
}

console.log("the sum of 10 first fibonacci is: "+sumFibonacci);