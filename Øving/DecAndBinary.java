import java.util.Scanner; 
import java.util.Arrays;

public class DecAndBinary {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        char[] binaryValue = new char[99];
        int BinToDec = 0;
        String[] bannedBinaryValues = {"2", "3", "4", "5", "6", "7", "8", "9"};
        boolean inProcess = true;
        boolean invalidNum = false;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (inProcess) {

        System.out.println("\nPlease enter the desired number to convert to decimals: ");
            String binaryString = read.nextLine();

            for (int i = 0; i < bannedBinaryValues.length; i++) {
                 if (binaryString.contains(bannedBinaryValues[i])) {
                    invalidNum = true;
                    System.out.println("\nIssue raised: Invalid binary number provided, please try again...");

                    try {
                        Thread.sleep(3000);
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                    } catch(InterruptedException e) {
                        System.out.println("Interrupted!");
                    }
                 }
            }

        System.out.println("\nBinary -> Decimal (0) \nBinary -> Hexadecimal (1) \n");
        String convertChoice = read.nextLine();

        if (convertChoice.equals("0")) { // Note: Java DOESN'T compare contents of strings using == {
            if (!invalidNum) {
                for (int i = 0; i < binaryString.length(); i++) {
                    char charAt = binaryString.charAt(i);
                    binaryValue[i] = charAt;
                }

                for (int i = 0; i < binaryValue.length; i++) {
                    if (binaryValue[i] == '1') {
                        BinToDec += Math.pow(2, (binaryString.length() - (i+1)));
                    }
                }
                
                System.out.println("The binary number: " + binaryString + " when converted to decimals is: " + BinToDec);
                Arrays.fill(binaryValue, '0');
            }

        } else if (convertChoice.equals("1")) {
            int tempValue = 0;
            int arrValue = 0;
            String[] hexNum = new String[99];
            String formattedHexNum = "";
            double hexLength = binaryString.length() / 4;

            if (!invalidNum) {
                    for (int i = 0; i < binaryString.length(); i++) { // Add every character from the string into an array.
                        char charAt = binaryString.charAt(i);
                        binaryValue[i] = charAt;
                    }

                    for (int i = 0; i < binaryString.length(); i++) { // Hexadecimal calculation
                        if (((i % 3 == 0) && (i != 0))) { // i has to be a divisible by 3 (Because arrays start from 0)
                            for (int j = i; j > (i-4); j--) { // and we split everything into 4x4s of binary strings
                                if (binaryValue[j] == '1') { // Here we count down from the divisible number till the end of the cell, subsequently returning the hexadecimal value.
                                    tempValue += Math.pow(2, (i - j)); // This then is added as an int
                                }
                            }
                            switch (tempValue) { // And the switch assign hexadecimal values if the number is greater than 9
                                    case 10: hexNum[arrValue] = "A"; break;
                                    case 11: hexNum[arrValue] = "B"; break;
                                    case 12: hexNum[arrValue] = "C"; break;                             
                                    case 13: hexNum[arrValue] = "D"; break;
                                    case 14: hexNum[arrValue] = "E"; break;
                                    case 15: hexNum[arrValue] = "F"; break;
                                    default: hexNum[arrValue] = Integer.toString(tempValue); break;                                                                                                   
                                    } 
                            
                            arrValue++;
                            tempValue = 0;
                        }
                        
                        System.out.println(Arrays.toString(hexNum));
                    }

                    String[] arrayHexNum = new String[(int) Math.ceil(hexLength)];
                    for (int i = 0; i < hexLength; i++) {
                        arrayHexNum[i] = hexNum[i];
                    }

                    formattedHexNum = String.join("", arrayHexNum);
                    
                    System.out.println("The binary number: " + binaryString + " when converted to hexadecimals is: " + formattedHexNum);
                    System.out.println(binaryString.length());
                }

        } else {
            System.out.println("Issue raised: Invalid choice provided, please try again...");
        }
    }
    }
}
