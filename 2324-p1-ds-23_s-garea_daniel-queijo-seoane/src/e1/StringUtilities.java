package e1;

import java.util.regex.Pattern;

public class StringUtilities {
    public static boolean isValidString(String string, String validString, int minLenght) {
        if (string == null || string.isEmpty())
            return false; //Un string nulo no es válido
        else //En cualquier otro caso, el string es válido
            if (string.length() < minLenght)
            return false; //Si un string tiene un tamaño menor al mínimo no es válido
        else return Pattern.matches("[" + validString + "0-9]+", string);
        //Si un string contiene uno o varios caracteres no permitidos (incluidos los número), el string no es válido.
    }
    public static String lowercaseFirst(String string) {
        char character;
        StringBuilder lowerFirst = new StringBuilder(), rest = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            character = string.charAt(i);
            if (Character.isLowerCase(character)) {
                lowerFirst.append(character);
            }
            else {
                rest.append(character);
            }
        }
        return lowerFirst.append(rest).toString();
    }
    public static boolean checkTextStats(String string, int minLength, int maxLength) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("La cadena no es válida, no puede ser nula ni vacía.");
        } else if (minLength < 1 || maxLength < 1 || minLength > maxLength) {
            throw new IllegalArgumentException("Los valores mínimo y máximo deben ser mayores que 0, y el mínimo debe ser menor o igual que el máximo.");
        } else {
            String[] words = string.split(" "); // Dividimos el texto en palabras (separadas por espacios)
            String longestWord = "";
            int totalLength = 0;

            for (String word : words) { // Por cada palabra
                String validWord = word.replaceAll("[^a-zA-Z]", ""); // Reemplazamos los caracteres no válidos
                totalLength += validWord.length(); // Sumamos su longitud a la longitud total
                if (validWord.length() > longestWord.length()) // Guardamos la palabra más larga
                    longestWord = validWord;
            }

            double averageLength = (double) totalLength / words.length;
            return (averageLength >= minLength && averageLength <= maxLength) && (longestWord.length() <= 2 * averageLength);
        }
    }


}
