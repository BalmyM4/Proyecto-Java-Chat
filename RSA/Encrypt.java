package RSA;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Encrypt {
    private static final int BIT_LENGTH = 2048; // Longitud de bits para las claves RSA

    // Método para generar un número primo aleatorio
    private static BigInteger generateRandomPrime() {
        SecureRandom random = new SecureRandom();
        return BigInteger.probablePrime(BIT_LENGTH, random);
    }

    // Método para guardar d en un archivo.
    private static void saveD( BigInteger d ) {
        try {
            FileWriter fw = new FileWriter("RSA/d.txt");
            fw.write( d.toString() );

            fw.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar n en un archivo.
    private static void saveN( BigInteger n ) {
        try {
            FileWriter fw = new FileWriter("RSA/n.txt");
            fw.write( n.toString() );

            fw.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar mensaje encriptado en un archivo.
    private static void saveEncryptedMessage( BigInteger encryptedMessage ) {
        try {
            FileWriter fw = new FileWriter("RSA/encryptedMessage.txt");
            fw.write( encryptedMessage.toString() );

            fw.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Elección de números primos p y q
        BigInteger p = generateRandomPrime();
        BigInteger q = generateRandomPrime();

        System.out.println("p: " + p);
        System.out.println("q: " + q);

        // Calcular n = p * q y φ(n) = (p - 1) * (q - 1)
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Elección de la clave pública e (usualmente 65537)
        BigInteger e = BigInteger.valueOf(65537);

        // Calcular clave privada d usando el algoritmo extendido de Euclides
        BigInteger d = e.modInverse(phiN);
        saveD(d);
        saveN(n);

        // Mensaje a encriptar
        String mensajeOriginal = "Hector tas muy guapo.";

        // Convertir el mensaje a un número (BigInteger)
        BigInteger mensajeNumero = new BigInteger(mensajeOriginal.getBytes());

        // Encriptación del mensaje
        BigInteger mensajeEncriptado = mensajeNumero.modPow(e, n);
        saveEncryptedMessage(mensajeEncriptado);

        // Mostrar el mensaje encriptado
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);
    }
}