public class FizzBuzz {

    public static boolean isFizz;
    public static boolean isBuzz;

    public static String fizzBuzz(int number){
        isFizz = number % 3 == 0;
        isBuzz = number % 5 == 0;
        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
