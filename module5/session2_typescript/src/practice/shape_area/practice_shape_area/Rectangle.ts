import {Shape} from "./Shape";

export class Rectangle extends Shape implements IArea {
    private _width:number;
    private _height:number;

    constructor(x:number,y:number,width: number, height: number) {
        super(x,y);
        this._width = width;
        this._height = height;
    }

    getWidth(): number {
        return this._width;
    }

    setWidth(value: number) {
        this._width = value;
    }

    getHeight(): number {
        return this._height;
    }

    setHeight(value: number) {
        this._height = value;
    }

    area(): number {
        return this._width*this._height;
    }

}