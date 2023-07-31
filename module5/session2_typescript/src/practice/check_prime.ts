
const isPrime = (numberToCheck:number) => {
    let isPrime:boolean = true;
    if(numberToCheck<2){
        isPrime=false;
    }else {
        let countDividable:number = 0;
        for (let i = 1;i<=numberToCheck;i++){
            if (numberToCheck%i==0){
                countDividable++;
            }
        }
        isPrime = countDividable <= 2;
    }
    return isPrime;
}

let numberArray = [1,2,3,4,5,6];
let sumPrime:number=0;
for (let i = 0;i<numberArray.length;i++){
    if (isPrime(numberArray[i])){
        sumPrime+=numberArray[i];
    }
}
console.log("the sum of primes in this array is: "+sumPrime);