package net.oleksin.kata.kyu8.reversedwords;

public class ReverseWords{
 public static String reverseWords(String str){
  final var split = str.split("\\s");
  for (int i = 0; i < split.length / 2; i++) {
   String tmp = split[i];
   split[i] = split[split.length - i - 1];
   split[split.length - i - 1] = tmp;
  }
  return String.join(" ", split);
 }
}