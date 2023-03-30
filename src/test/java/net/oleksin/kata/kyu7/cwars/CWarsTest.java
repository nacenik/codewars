package net.oleksin.kata.kyu7.cwars;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CWarsTest {

    private static String namesData = "Noah Liam Mason Jacob William Ethan Michael Alexander James Daniel Miguel David Arthur Pedro Gabriel Bernardo Lucas Matheus Rafael Hector Emma Olivia Sophia Isabella Ava Ygritte Emily Abigail Madison Charlotte Caroline Alice Julia Zoe Manuela Laura Luiza Valentina Giovanna Maria Eduarda";

    private static String lastnamesData = "Smith Johnson Williams Jones Brown Davis Miller Wilson Moore Taylor Anderson Thomas Jackson White Harris Martin Thompson Garcia Martinez Robinson Clark Rodriguez Lewis Lee Walker Hall Allen Young Hernandez King Wright Lopez Hill Scott Green Adams Baker Gonzalez Nelson Carter Mitchell Perez Roberts Turner Phillips Campbell Parker Evans Edwards Collins Stewart Sanchez Morris Rogers Reed Cook Morgan Bell Murphy Bailey Rivera Cooper Richardson Cox Howard Ward Torres Peterson Gray Ramirez James Watson Brooks Kelly Sanders Price Bennett Wood Barnes Ross Henderson Coleman Jenkins Perry Powell Long Patterson Hughes Flores Washington Butler Simmons Foster Gonzales Bryant Alexander Russell Griffin Diaz Hayes";

    private static String[] names;

    private static String[] lastnames;

    private Random random = new Random();

    @BeforeAll
    public static void setup() {
        names = namesData.split(" ");
        lastnames = lastnamesData.split(" ");
    }

    @Test
    public void testInitials() {
        System.out.println("Testing 42 randomly generated names...\n");
        for (int i = 0; i < 42; i++) {
            int numberOfNameParts = random.nextInt(7) + 1;  // [0,7) +1  ==> between 1 and 7
            String[] originalName = new String[numberOfNameParts+1]; // +1 for the lastname

            pickRandomNamesElements(originalName, names, numberOfNameParts);
            pickRandomLastName(originalName, lastnames);
            String inputName = createSringWithRandomLowercasedElements(originalName);

            assertEquals("Testcase " + (i+1) + " failed for input: '" + inputName + "'", produceExpectedName(originalName), CWars.initials(inputName));
        }
    }

    private String createSringWithRandomLowercasedElements(String[] originalName) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalName.length; i++) {
            if (random.nextBoolean()) {
                result.append(originalName[i].toLowerCase());
            } else {
                result.append(originalName[i]);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    private void pickRandomNamesElements(String[] originalName, String[] names, int number) {
        for (int i = 0; i < number; i++) {
            originalName[i] = names[random.nextInt(names.length)];
        }
    }

    private void pickRandomLastName(String[] originalName, String[] lastnames) {
        originalName[originalName.length-1] = lastnames[random.nextInt(lastnames.length)];
    }

    private String produceExpectedName(String[] originalName) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalName.length - 1; i++) {
            result.append(originalName[i].substring(0, 1));
            result.append(".");
        }
        result.append(originalName[originalName.length-1]);

        return result.toString();
    }

    @Test
    public void testExamples() {
        assertEquals("C.Wars", CWars.initials("code wars"));
        assertEquals("B.H.Obama", CWars.initials("Barack hussain obama"));
        assertEquals("B.H.Obama", CWars.initials("barrack hussain Obama"));
    }
}