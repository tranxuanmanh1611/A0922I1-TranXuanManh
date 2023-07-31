"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.Rectangle = void 0;
var Shape_1 = require("./Shape");
var Rectangle = /** @class */ (function (_super) {
    __extends(Rectangle, _super);
    function Rectangle(x, y, width, height) {
        var _this = _super.call(this, x, y) || this;
        _this._width = width;
        _this._height = height;
        return _this;
    }
    Rectangle.prototype.getWidth = function () {
        return this._width;
    };
    Rectangle.prototype.setWidth = function (value) {
        this._width = value;
    };
    Rectangle.prototype.getHeight = function () {
        return this._height;
    };
    Rectangle.prototype.setHeight = function (value) {
        this._height = value;
    };
    Rectangle.prototype.area = function () {
        return this._width * this._height;
    };
    return Rectangle;
}(Shape_1.Shape));
exports.Rectangle = Rectangle;
