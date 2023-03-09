


public class Test {
    public static void main(String[] args) {
        String str ="aaabbaaac";
        String str3 = encodeString(str);
        System.out.println(str3);
    }

    public static String encodeString(String str) {
        //Your code here
            String str2 = "";
            for (int i = 0; i < str.length();i++) {
                int count = 0;
                for (int j = i; j < str.length(); j++) {
                    if (str.charAt(j) == str.charAt(i)) {
                        count++;
                    }
                    if (str.charAt(j) != str.charAt(i)||j==str.length()-1) {
                        str2 += str.charAt(i);
                        str2 += count;
                        i=j-1;
                        break;
                    }
                }
            }

            return str2;
    }
}

