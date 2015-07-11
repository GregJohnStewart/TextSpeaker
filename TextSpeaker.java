/* TextSpeaker.java
 * text-to speech program
 * v1.0T A
 * Greg Stewart
 * Last Edit: 10:18PM EDT 6/5/13
 * 
 */

//package TextSpeaker;

//import needed modules
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextSpeaker {
    
    
    
    
    //static methods for little things
    
    
    //method to 
    
    public static void main(String args[]){
        
        //make keyboard scanner
        Scanner keyboard = new Scanner(System.in);
        
        
        //instance variables (loop controls, default text input, starting sentence)
        
        boolean run = true;
        
        VoiceComp playingSentence;
        
        String inputText = null;
        
        
        
        //intro lines
        System.out.println("# Text Speaker");
        System.out.println("# Program Version 1.0TA");
        System.out.println("# Author: Greg Stewart");
        System.out.println("# Copyright 2014");
        
        /* 
         * Start actual program
         */
        
        while(run){
            
            //output for prompt
            System.out.println("Enter a phrase to be spoken ('\\exit' to exit):");
            
            inputText = keyboard.nextLine();
            inputText += "  ";
            
            System.out.println("Sentence input: \""+inputText+"\"");
            
            if(inputText.equals("\\exit")){
                inputText = "Exiting";
                run = false;
            }
            
            playingSentence = new VoiceComp(inputText);
            
            playingSentence.playSentence();
            
            System.out.println("\n");
			
        }//while run
        
    }//main
}//TextSpeaker class
       
