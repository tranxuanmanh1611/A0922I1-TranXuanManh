var count = 0;
var aNumber = 2;
var sum = 0;
while (count <= 30) {
    var isPrime = true;
    var divisibleCount = 0;
    for (var i = 1; i <= aNumber; i++) {
        if (aNumber % i == 0) {
            divisibleCount++;
        }
    }
    if (divisibleCount > 2) {
        isPrime = false;
        console.log(aNumber + " is not a prime");
        aNumber++;
        console.log("continuing with: " + aNumber);
        continue;
    }
    if (isPrime) {
        console.log(aNumber + " is a prime");
        sum += aNumber;
        aNumber++;
        count++;
        console.log("consecutive sum: " + sum);
        console.log("aNumber: " + aNumber);
        console.log("count: " + count);
    }
}
console.log("sum of 30 first prime number is: " + sum);
