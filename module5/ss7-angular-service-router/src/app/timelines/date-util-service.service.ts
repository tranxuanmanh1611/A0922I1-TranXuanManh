import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DateUtilServiceService {

  constructor() { }

  getDifferenceWithNow(value: string|number|Date): string {
    const timeToCheck = new Date(value);
    const now = new Date();
    const result: string[] = [];

    const year = this.differentInYear(timeToCheck , now);
    if (year > 0) {
      result.push(`${year} years`);
    }
    const month = this.differentInMonth(timeToCheck , now);
    if (month > 0) {
      result.push(`${month} months`);
    }
    const date  = this.differnetInDay(timeToCheck , now);
    if (date > 0) {
      result.push(`${date} days`);
    }
    return result.join(' ');
  }

  differentInYear(from: Date, to: Date): number {
    return (to.getFullYear()  - from.getFullYear());
  }
  differentInMonth(from: Date, to: Date): number {
    return (to.getMonth() - from.getMonth());
  }
  differnetInDay(from: Date, to: Date): number {
    return (to.getDate() - from.getDate());
  }

}
