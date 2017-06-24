/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.util.*;

/**
 *
 * @author Elena
 */
public class World {

    static int width;
    static int length;
    static Person[][] person;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random rand = new Random();
        width = 100;
        length = 100;

        person = new Person[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.println("position " + i + "," + j);
                person[i][j] = new Person();
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                person[i][j].contacts = makeContactList();
                person[i][j].printPerson();
            }
        }
//        
        runTurn();
    }

    public static void printStatus() {
        int statusI = 0;
        int statusS = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {

                if (person[i][j].state == 'i') {
                    statusI++;
                }
                if (person[i][j].state == 's') {
                    statusS++;
                }
            }
        }
        System.out.println("i:" + statusI + " s:" + statusS);
    }

    public static Person[] makeContactList() {
        Person[] listp = new Person[50];

        int[] listb = new int[50];
        Random p = new Random();

        for (int j = 0; j < 50; j++) {
            listb[j] = p.nextInt(width);
            {
            }
        }

        int[] listl = new int[50];
        p = new Random();

        for (int j = 0; j < 50; j++) {
            listl[j] = p.nextInt(length);
            {
            }
        }
        for (int j = 0; j < 50; j++) {
            listp[j] = person[listb[j]][listl[j]];
        }
        return listp;

    }

    static void runTurn() {
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (person[i][j].state == 's') {
                    Person[] contacts = person[i][j].contacts;
                    for (int n = 0; n < 50; n++) {
                        if (contacts[n].state == 'i') {
                            int p = rand.nextInt(100);
                            if (p < 30) {
                                person[i][j].state = 'i';
                                person[i][j].virus = new Virus();
                            }
                        }
                    }
                }
            }
        }
        printStatus();
    }
}
