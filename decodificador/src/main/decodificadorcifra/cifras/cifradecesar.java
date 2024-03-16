package cipherdecoder.cifras;

public class CifraDeCesar {
    public static String decifrar(String textoCifrado, int deslocamento) {
        StringBuilder textoPlano = new StringBuilder();
        for (char c : textoCifrado.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int offset = (c - base - deslocamento + 26) % 26;
                textoPlano.append((char) (base + offset));
            } else {
                textoPlano.append(c);
            }
        }
        return textoPlano.toString();
    }
}
