package net.oleksin.kata.kyu6.duplicateencoder;

public class DuplicateEncoder {
	static String encode(String word){
    word = word.toLowerCase();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      sb.append(word.lastIndexOf(ch) == word.indexOf(ch) ? "(" : ")");
    }
    return sb.toString();
  }
}