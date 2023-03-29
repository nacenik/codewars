package net.oleksin.kata.kyu7.creditcardmask;

public class Maskify {
    public static String maskify(String str) {
        return str.length() < 4 ? str : str.substring( 0, str.length() - 4 ).replaceAll( ".", "#" ) + str.substring( str.length() - 4 );
    }
}