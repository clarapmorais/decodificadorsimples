package cipherdecoder.morse;

public class CodigoMorse {
    private static final String[] codigosMorse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..",
            ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----",
            ".-.-.-", "--..--", "..--..", "-.-.--", "-....-", ".----.", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", ".-..-.", ".--.-.", "-...-"
    };
    private static final char[] letrasDigitos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,?'!/()&:;=+-_\"$@".toCharArray();

    public static String decodificar(String codigoMorse) {
        StringBuilder resultado = new StringBuilder();
        String[] palavras = codigoMorse.split("\\s{2,}");
        for (String palavra : palavras) {
            String[] letras = palavra.split("\\s+");
            for (String letra : letras) {
                String letraDecodificada = decodificarLetra(letra);
                resultado.append(letraDecodificada);
            }
            resultado.append(" ");
        }
        return resultado.toString();
    }

    private static String decodificarLetra(String letraMorse) {
        for (int i = 0; i < codigosMorse.length; i++) {
            if (letraMorse.equals(codigosMorse[i])) {
                return String.valueOf(letrasDigitos[i]);
            }
        }
        return "";
    }
}
