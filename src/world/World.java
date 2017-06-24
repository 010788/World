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
        System.out.println("Initial state");
        printStatus();
        runTurn();
        printStatus();
        runTurn();
        printStatus();
        runTurn();
        printStatus();
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

    public static int[][] makeContactList() {
        int[][] posList = new int[50][2];
        Random p = new Random();

        for (int j = 0; j < 50; j++) {
            posList[j][0] = p.nextInt(width);
            {
            }
        }
        p = new Random();

        for (int j = 0; j < 50; j++) {
            posList[j][1] = p.nextInt(length);
            {
            }
        }

        return posList;

    }

    static void runTurn() {
        System.out.println("Run simulation");
     
        Person[][] newPersons = copyPersons();
        Random rand = new Random();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (person[i][j].state == 's') {
                    int[][] contacts = person[i][j].contacts;
                    for (int n = 0; n < 50; n++) {
                        if (person[contacts[n][0]][contacts[n][1]].state == 'i') {
                            int p = rand.nextInt(100);
                            if (p < 30) {
                                newPersons[i][j].state = 'i';
                                newPersons[i][j].virus = new Virus();
                            }
                        }
                    }
                } else if (person[i][j].state == 'i') {
                    int[][] contacts = person[i][j].contacts;
                    for (int n = 0; n < 50; n++) {
                        Person contact = person[contacts[n][0]][contacts[n][1]];
                        if (contact.state == 's') {
                            int p = rand.nextInt(100);
                            if (p < 30) {
                                newPersons[contacts[n][0]][contacts[n][1]].state = 'i';
                                newPersons[contacts[n][0]][contacts[n][1]].virus = new Virus();
                            }
                        }
                    }
                }
            }
        }
        person = newPersons;

    }
    
    public static Person[][] copyPersons () {
        Person[][] newPersons = new Person[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                newPersons[i][j] = new Person();
                newPersons[i][j].age = person[i][j].age;
                newPersons[i][j].gender = person[i][j].gender;
                newPersons[i][j].state = person[i][j].state;
                newPersons[i][j].virus = person[i][j].virus;
                newPersons[i][j].contacts = person[i][j].contacts;
                
            }
        }
        return newPersons;
    }
}
