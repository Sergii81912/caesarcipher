package com.company;

import java.io.*;

public class CeasarCipher {

    public static void main(String[] args) {
        File encryptedFile = new File("ceasarCipher.txt");
        try {
            BufferedReader openingText = new BufferedReader(new FileReader("ceasarText.txt"));
            String textFile;
            while ((textFile = openingText.readLine()) != null) {
                System.out.print(textFile);

                int cipherKey = 3;
                char[] symbol = new char[textFile.length()];
                for (int i = 0; i < textFile.length(); i++) {
                    if (Character.isLetter(textFile.charAt(i)) && Character.isUpperCase(textFile.charAt(i))) {
                        symbol[i] = (char) (((((int) (textFile.charAt(i))) - 1040 + cipherKey) % 33) + 1040);
                    } else if (Character.isLetter(textFile.charAt(i)) && Character.isLowerCase(textFile.charAt(i))) {
                        symbol[i] = (char) (((((int) (textFile.charAt(i))) - 1072 + cipherKey) % 33) + 1072);
                    } else
                        symbol[i] = textFile.charAt(i);
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile));
                String code = String.copyValueOf(symbol);
                writer.write(code);
                writer.close();
                System.out.println(" -> " + code);

                int discountKey = 30;
                char[] encryptedCharacter = new char[code.length()];
                for (int i = 0; i < code.length(); i++) {
                    if (Character.isLetter(code.charAt(i)) && Character.isUpperCase(code.charAt(i))) {
                        encryptedCharacter[i] = (char) (((((int) (code.charAt(i))) - 1040 + discountKey) % 33) + 1040);
                    } else if (Character.isLetter(code.charAt(i)) && Character.isLowerCase(code.charAt(i))) {
                        encryptedCharacter[i] = (char) (((((int) (code.charAt(i))) - 1072 + discountKey) % 33 + 1072));
                    } else
                        encryptedCharacter[i] = code.charAt(i);
                }
                System.out.print(code + " -> ");
                System.out.print(encryptedCharacter);

            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}

