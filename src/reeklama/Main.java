package reeklama;

import java.io.*;
import java.util.Scanner;


public class Main {

    // шифруем строку
    // передаем текст и ключ
    public static String stringEncryption(String text,
                                          String key)
    {
        String cipherText = "";

        // массив шифров для суммы номеров ключа и текста
        int cipher[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            cipher[i] = text.charAt(i) - 'A'
                    + key.charAt(i)
                    - 'A';
        }

        // если сумма больше 25, вычитаем из нее 26 и сохраняем полученное значение
        for (int i = 0; i < key.length(); i++) {
            if (cipher[i] > 25) {
                cipher[i] = cipher[i] - 26;
            }
        }

        // преобразуем номера в числа, а числа в соответствующие символы
        for (int i = 0; i < key.length(); i++) {
            int x = cipher[i] + 'A';
            cipherText += (char)x;
        }

        return cipherText;
    }


    //процесс обратный
    public static String stringDecryption(String s,
                                          String key)
    {
        String plainText = "";

        int plain[] = new int[key.length()];

        for (int i = 0; i < key.length(); i++) {
            plain[i]
                    = s.charAt(i) - 'A'
                    - (key.charAt(i) - 'A');
        }

        for (int i = 0; i < key.length(); i++) {
            if (plain[i] < 0) {
                plain[i] = plain[i] + 26;
            }
        }

        for (int i = 0; i < key.length(); i++) {
            int x = plain[i] + 'A';
            plainText += (char)x;
        }

        return plainText;
    }


    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text message: ");
        String plainText = scanner.nextLine(); // текст для шифрования

        System.out.println("Input key(same length with message): ");
        String key = scanner.nextLine(); //ключ для шифрования

        //шифруем, изначально переведя в uppercase
        String encryptedText = stringEncryption(plainText.toUpperCase(), key.toUpperCase());

        //выводим зашифрованный текст
        System.out.println("Cipher Text - " + encryptedText);

        //расшифровываем
        String decryptedText = stringDecryption(encryptedText, key.toUpperCase());

        //выводим зашифрованный текст
        System.out.println("Message - " + decryptedText);
    }
}
