package RSA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

public class Decrypt {

    // Método para leer la d desde un archivo.
    private static BigInteger readD() {
        try {
            FileReader fr = new FileReader("RSA/d.txt");
            BufferedReader br = new BufferedReader(fr);
            BigInteger key = new BigInteger( br.readLine() );
            br.close();
            return key ;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return BigInteger.valueOf(0);
    }

    // Método para leer la n desde un archivo.
    private static BigInteger readN() {
        try {
            FileReader fr = new FileReader("RSA/n.txt");
            BufferedReader br = new BufferedReader(fr);
            BigInteger key = new BigInteger( br.readLine() );
            br.close();
            return key ;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return BigInteger.valueOf(0);
    }

    // Método para leer el mensaje encriptado desde un archivo.
    private static BigInteger readEncryptedMessage() {
        try {
            FileReader fr = new FileReader("RSA/encryptedMessage.txt");
            BufferedReader br = new BufferedReader(fr);
            BigInteger key = new BigInteger( br.readLine() );
            br.close();
            return key ;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return BigInteger.valueOf(0);
    }


    public static void main(String[] args) {

        BigInteger mensajeEncriptado = readEncryptedMessage();

        BigInteger d = readD();
        BigInteger n = readN();

        // Desencriptación del mensaje
        BigInteger mensajeDesencriptado = mensajeEncriptado.modPow(d, n);

        // Convertir el mensaje desencriptado a una cadena de texto
        String mensajeOriginal = new String(mensajeDesencriptado.toByteArray());

        // Mostrar el mensaje desencriptado
        System.out.println("Mensaje desencriptado: " + mensajeOriginal);
    }
}
