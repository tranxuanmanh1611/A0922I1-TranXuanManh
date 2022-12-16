
import java.util.Scanner;

public class ConvertNumbers {
    public static void main(String[] args) {
        String[] lowerTen = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] lowerTwenty = {"ten", "eleven", "twelve", "third", "four", "fif", "six", "seven", "eight", "nine"};
        String[] lowerHundred = {"twen", "third", "four", "fif", "six", "seven", "eight", "nine"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so can doc?");
        short numbers = scanner.nextShort();
        String result = null;
        if (numbers <= 0 || numbers > 999) {
            System.out.println("Nam ngoai kha nang");
        } else {
            if (numbers < 10) {
                result = lowerTen[numbers - 1];
            } else if (numbers < 20) {

                int rest = numbers % 10;
                if (rest < 3) {
                    result = lowerTwenty[rest];
                } else {
                    result = lowerTwenty[rest] + "teen";
                }
            } else if (numbers < 100) {
                int restOne = numbers % 10;
                int tenes = (numbers - restOne) / 10;
                if (restOne == 0) {
                    result = lowerHundred[tenes - 2] + "ty";
                } else {
                    result = lowerHundred[tenes - 2] + "ty " + lowerTen[restOne - 1];
                }
            } else {
                int restTen = numbers % 100;
                int restOne = restTen % 10;
                int ten = (restTen - restOne) / 10;
                int hundred = (numbers - restTen) / 100;
                if (restTen == 0) {
                    result = lowerTen[hundred - 1] + " hundred";
                } else {
                    if (restOne == 0) {
                        if (ten == 1) {
                            result = lowerTen[hundred - 1] + " hundred and ten";
                        } else {
                            result = lowerTen[hundred - 1] + " hundred and " + lowerHundred[ten - 2] + "ty";
                        }
                    } else {
                        if (ten == 1) {
                            if (restOne < 3) {
                                result = lowerTen[hundred - 1] + " hundred and " + lowerTwenty[restOne];
                            } else {
                                result = lowerTen[hundred - 1] + " hundred and " + lowerTwenty[restOne] + "teen";
                            }
                        } else {
                            result = lowerTen[hundred - 1] + " hundred and " + lowerHundred[ten - 2] + "ty " + lowerTen[restOne-1];
                        }
                    }
                }
            }
        }
        System.out.println("Number: " + numbers + ", read: " + result);
    }
}







