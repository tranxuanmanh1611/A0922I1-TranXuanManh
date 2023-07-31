const buyACar = (car: String, money: number) => {
    return new Promise(((resolve, reject) => {
        setTimeout(() => {
                if (money >= 10000) {
                    resolve("can buy " + car);
                } else {
                    reject("Do not enough money");
                }
            }, 100
        );
    }))
}

const promiseTest = buyACar("VF8", 9999).then(value => {
    console.log(value);
}, error => {
    console.log(error);
});