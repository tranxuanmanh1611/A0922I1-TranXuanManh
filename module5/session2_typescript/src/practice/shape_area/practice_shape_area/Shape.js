"use strict";
exports.__esModule = true;
exports.Shape = void 0;
var Shape = /** @class */ (function () {
    function Shape(x, y) {
        this._x = x;
        this._y = y;
    }
    Shape.prototype.getX = function () {
        return this._x;
    };
    Shape.prototype.setX = function (value) {
        this._x = value;
    };
    Shape.prototype.getY = function () {
        return this._y;
    };
    Shape.prototype.setY = function (value) {
        this._y = value;
    };
    Shape.prototype.toString = function () {
        return '(x: ${this._x},y: ${this._y})';
    };
    return Shape;
}());
exports.Shape = Shape;
