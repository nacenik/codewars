package net.oleksin.kata.kyu7.cwars;

class CWars {
    public static String initials(String name){
        final var stringBuilder = new StringBuilder();
        final var split = name.split("\\s");
        for (int i = 0; i < split.length - 1; i++) {
            stringBuilder
                    .append(Character.toUpperCase(split[i].charAt(0)))
                    .append(".");
        }
        stringBuilder.append(Character.toUpperCase(split[split.length - 1].charAt(0)))
                .append(split[split.length - 1].substring(1));
        return stringBuilder.toString();
    }

}