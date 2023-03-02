import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean validateFind(String data){
        String findRegex ="(\\d{12})?[\\w\\s]+";
        Pattern pattern = Pattern.compile(findRegex);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }


  public static boolean validateCardNumber(String cardNumber){
      String cardNumberRegex = "\\d{12}";
      Pattern pattern = Pattern.compile(cardNumberRegex);
      Matcher matcher = pattern.matcher(cardNumber);
      return matcher.matches();
  }
    public static boolean validateCitizenId(String citizenId){
        String citizenRegex = "\\d{12}";
        Pattern pattern = Pattern.compile(citizenRegex);
        Matcher matcher = pattern.matcher(citizenId);
        return matcher.matches();
    }
}
