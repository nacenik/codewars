package net.oleksin.kata.kyu6.simpleencryptionalternatingsplit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleEncryptionAlternatingSplitTest {
    private static String refEncrypt(final String text, final int n) {
        if (text == null) {
            return null;
        }
        String t =text;
        for (int i=0; i<n; i++) {
            String even = "";
            String odd = "";
            for (int j=0; j<t.length(); j++) {
                if (j%2==0) even += t.charAt(j); else odd += t.charAt(j);
            }
            t = odd + even;
        }
        //System.out.println("Ref Encrypted: " + t);
        return t;
    }

    // Reference implementation decrypt (for random tests)
    private static String refDecrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.length() == 0) {
            return encryptedText;
        }
        String decrypted = encryptedText;
        for (int i=0; i<n; i++) {
            final String odd = decrypted.substring(0, decrypted.length()/2);
            final String even = decrypted.substring(decrypted.length()/2);
            decrypted = "";
            int o=0,e=0;
            do {

                if (e<even.length()) decrypted += even.charAt(e++);
                if (o<odd.length()) decrypted += odd.charAt(o++);

            } while (e<even.length()||o<odd.length());
        }
        //System.out.println("Ref Decrypted: " + decrypted);
        return decrypted;
    }

    // -------------------------------------------------------------------

    @Test
    public void encryptExampleTests() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 0));
        assertEquals("hsi  etTi sats!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 1));
        assertEquals("s eT ashi tist!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 2));
        assertEquals(" Tah itse sits!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 3));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.encrypt("This is a test!", -1));
        assertEquals("hskt svr neetn!Ti aai eyitrsig", SimpleEncryptionAlternatingSplit.encrypt("This SimpleEncryptionAlternatingSplit is very interesting!", 1));
    }

    @Test
    public void decryptExampleTests() {
        // assertEquals("expected", "actual");
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", 0));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("hsi  etTi sats!", 1));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("s eT ashi tist!", 2));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt(" Tah itse sits!", 3));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", 4));
        assertEquals("This is a test!", SimpleEncryptionAlternatingSplit.decrypt("This is a test!", -1));
        assertEquals("This SimpleEncryptionAlternatingSplit is very interesting!", SimpleEncryptionAlternatingSplit.decrypt("hskt svr neetn!Ti aai eyitrsig", 1));
    }

    @Test
    public void encryptDecryptTests() {
        // assertEquals("expected", "actual");  
        assertEquals("Kobayashi-Maru-Test", SimpleEncryptionAlternatingSplit.decrypt(SimpleEncryptionAlternatingSplit.encrypt("Kobayashi-Maru-Test", 10), 10));
    }

    @Test
    public void nullOrEmpty() {
        // assertEquals("expected", "actual");
        assertEquals("", SimpleEncryptionAlternatingSplit.encrypt("", 0));
        assertEquals("", SimpleEncryptionAlternatingSplit.decrypt("", 0));
        assertEquals(null, SimpleEncryptionAlternatingSplit.encrypt(null, 0));
        assertEquals(null, SimpleEncryptionAlternatingSplit.decrypt(null, 0));
    }

    @Test
    public void random() {
        for (int i=0; i<20; i++) {
            final int n = (int)(Math.random()*10);
            final int length = (int)(Math.random()*69)+1;
            String text = "";
            for (int t=0; t<length; t++) {
                text += Character.toString((char)('A'+(int)(Math.random()*26)));
            }
            //System.out.println("Text is: "+text);

            // assertEquals("expected", "actual");
            assertEquals(text, refDecrypt(refEncrypt(text, n), n)); // verfy that the reference impl is good :-)
            assertEquals(refEncrypt(text, n), SimpleEncryptionAlternatingSplit.encrypt(text, n));
            assertEquals(refDecrypt(text, n), SimpleEncryptionAlternatingSplit.decrypt(text, n));
            assertEquals(text, SimpleEncryptionAlternatingSplit.decrypt(SimpleEncryptionAlternatingSplit.encrypt(text, n), n));
        }
    }
}