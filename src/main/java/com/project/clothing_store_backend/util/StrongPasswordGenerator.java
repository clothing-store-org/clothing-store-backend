package com.project.clothing_store_backend.util;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class StrongPasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    private  final SecureRandom RANDOM = new SecureRandom();


    public  String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        // Ensure the password includes at least one character from each group
        password.append(getRandomCharacter(UPPERCASE));
        password.append(getRandomCharacter(LOWERCASE));
        password.append(getRandomCharacter(DIGITS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Fill the rest of the password with random characters from all groups
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARACTERS));
        }

        // Shuffle the characters to make the password unpredictable
        return shuffleString(password.toString());
    }

    private  char getRandomCharacter(String characterSet) {
        int index = RANDOM.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }

    private  String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}