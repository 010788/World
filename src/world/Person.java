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
class Person {
        
    Random rand = new Random();
    int age;
    char gender;
    char state;
    Person[] contacts;
    Virus virus;
    
        public Person(){
            age = rand.nextInt(100);
            int p = rand.nextInt(100);
                if(p > 50){
                    gender = 'F';
                } else
                    gender = 'M';
            int q = rand.nextInt(10000);
                if(q < 50){
                    state = 'i';
                    virus = new Virus();
                } else 
                    state = 's';
        }
        
                
        public void printPerson(){
            System.out.println("person!"+age+gender+state+Arrays.toString(contacts));
        }
        
        
    }    

