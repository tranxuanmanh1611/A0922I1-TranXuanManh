var buyACar = function (car, money) {
    return new Promise((function (resolve, reject) {
        setTimeout(function () {
            if (money >= 10000) {
                resolve("can buy " + car);
            }
            else {
                reject("Do not enough money");
            }
        }, 100);
    }));
};
var promiseTest = buyACar("VF8", 9999).then(function (value) {
    console.log(value);
}, function (error) {
    console.log(error);
});
