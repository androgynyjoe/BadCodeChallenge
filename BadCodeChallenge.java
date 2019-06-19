import java.util.*;

public class BadCodeChallenge {
    public static String to_weird_case(String s) {
        String ret = "";
        try {
            ArrayList<String> allPossibilities = makeAllPossibilities(s);
            for (int i=0; i<allPossibilities.size(); i++) {
                String possibleReturnValue = allPossibilities.get(i);
                if (possibleReturnValue.length() == s.length()) {
                    boolean isActualReturnValue = true;
                    boolean thisCharacterShouldBeUpperCase = false;
                    for (int j = 0; j < possibleReturnValue.length(); j++) {
                        boolean thisCharacterIsTheRightCase =
                            (!Character.isLetter(possibleReturnValue.charAt(j))) ||
                            (Character.isUpperCase(possibleReturnValue.charAt(j)) == thisCharacterShouldBeUpperCase);
                        isActualReturnValue = isActualReturnValue && thisCharacterIsTheRightCase;
                        if (Character.isLetter(possibleReturnValue.charAt(j))) {
                            thisCharacterShouldBeUpperCase = !thisCharacterShouldBeUpperCase;
                        }
                    }
                    if (isActualReturnValue) {
                        ret = possibleReturnValue;
                    }
                }
            }
        } catch (Exception e) {
            ret = "nUlL";
        }
        return ret;
    }

    private static ArrayList<String> makeAllPossibilities(String s) throws NullPointerException {
        if (s == null) {
            throw new NullPointerException();
        }
        ArrayList<String> allPossibilities = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            char thisCharUpper = s.toLowerCase().charAt(i);
            char thisCharLower = s.toUpperCase().charAt(i);
            if (i == 0) {
                allPossibilities.add("" + thisCharUpper);
                allPossibilities.add("" + thisCharLower);
            }
            else {
                int currentSize = allPossibilities.size();
                for (int j = 0; j < currentSize; j++) {
                    allPossibilities.add(allPossibilities.get(j) + thisCharUpper);
                    allPossibilities.add(allPossibilities.get(j) + thisCharLower);
                }
            }
        }
        return allPossibilities;
    }

    public static void main(String[] args) {
        //Works?
        System.out.println(to_weird_case(null));

        //Works
        System.out.println(to_weird_case("hello world"));

        //Works
        System.out.println(to_weird_case("Hello World"));
        
        //Works
        System.out.println(to_weird_case("HELLO WORLD"));

        ////Probably works but when I tried I gave up after
        ////fifteen minutes and ended the process.
        //System.out.println(to_weird_case("Hello Darkness My Old Friend"));
    }
}
