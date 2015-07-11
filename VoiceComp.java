/* VoiceComp.java
 * sound object classes for the TextSpeaker program
 * v1.0A
 * Author: Greg Stewart
 * Last Edit: 12:21PM EDT 6/6/13
 * 
 */
//package TextSpeaker;

public class VoiceComp {
    /* 
     * instance variables
     */
    
    //the string currently being used
    private String sentence = null;
    
    //the number of characters in currentSentence
    private int numChars = 0;
    
    //array that holds the sound objects (big as charArray)
    private SpeechNode head;
    
    //the length of the finalSounds array
    int finalCount = 0;
    
    /*
     * constructor
     */
    public VoiceComp(){
        //do nothing. just to create the object
        
    }
    
    public VoiceComp(String sentence){
        //set the string
        this.sentence = sentence;
        
        //call newSentence
        newSentence();
    }
    
    
    /*
     * Setters
     */
    
    //sets a new sentence and builds the new array of sounds
    public void setSentence(String input){
        
        this.sentence = input;
        
        //call newSentence
        newSentence();
        
        
    }
    
    private void newSentence(){
        System.out.println("Working...");
        //set the new length of charachters
        numChars = sentence.length();
        
        //call the processing algorythm
        processIt();
        
        System.out.println("Finished.");
    }
    
    /*
     * Getters
     */
    
    //returns the current sentence
    public String getSentence(){
        return sentence;
    }
    
    //plays just once, simply calls the other, and tells it to play just once 
    public void playSentence(){
        playSentence(1);
    }
    
    //plays the current finalSounds a certain amount of times
    public void playSentence(int repeat){
        SpeechNode current;
        
        for(int i = 0;i < repeat;i++){
            current = head;
            System.out.println("Playing the "+i+" time");
            while(current.getNext() != null){
                
                current.play();
                
                current = current.getNext();
                
            }
        }
    }//playSentence
    
    /*
     * to save the current construction as one wav file
     */
    public void saveFile(String fileName){
        System.out.println("saveFile method called");
    }
    
    /////////////////////
    //  Other classes  //
    /////////////////////
    /*
     public static void playSound(final String url) {
     // Clip finishing; see comments.
     try {
     Clip clip = AudioSystem.getClip();
     AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/path/to/sounds/" + url));
     clip.open(inputStream);
     clip.start(); 
     } catch (Exception e) {
     System.err.println(e.getMessage());
     }
     }
     */
    
    /* ProcessIt()
     * function to make the entire LL based on the string
     * 
     * 
     */
    public void build(){
        System.out.println("Entered processIt()");
        /*
         * Instance Variables
         */
        
        
        int i = 0;//where we are in the string
        char currentLetter = sentence.charAt(i);//the charachter at that point
        System.out.println("Set initial variables");
        
        //set initial space
        head = new SpeechNode("sounds/other/space.wav");
        System.out.println("set head's sound");
        
        //create value to keep first
        SpeechNode first = head;
        
        //create the previous
        //SpeechNode previous = head;
        //System.out.println("Set previous = head");
        
        //set head's next to previous
        //head.setNext(previous);
        
        
        System.out.println("Length of string: " + sentence.length());
        
        while(i < sentence.length()){
            currentLetter= sentence.charAt(i);
            System.out.println("At charachter "+i+". Charcahter: '"+currentLetter+"'");
            
            SpeechNode next = new SpeechNode();
            
            switch(currentLetter){//set the sound based on the letter
                
                //////////////
                //  Vowels  //
                //////////////
                case 'a':
                case 'A':{
                    
                    next.setSound("sounds/vowels/a.wav");
                    
                    break;
                }case 'e':
                case 'E':{
                    
                    next.setSound("sounds/vowels/e.wav");
                    
                    break;
                }case 'i':
                case 'I':{
                    
                    next.setSound("sounds/vowels/i.wav");
                    
                    break;
                }case 'o':
                case 'O':{
                    
                    next.setSound("sounds/vowels/o.wav");
                    
                    break;
                }case 'u':
                case 'U':{
                    
                    next.setSound("sounds/vowels/u.wav");
                    
                    break;
                }case'y':
                case'Y':{
                    
                    next.setSound("sounds/vowels/y.wav");
                    break;
                    
                //////////////////
                //  Consenants  //
                //////////////////
                }case 'b':
                case 'B':{
                    //if by itself, say the actual name of the charachter
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/b.wav");
                        
                    }else{//otherwise, say the phonetic pronunciation
                        // 'buh' sound
                    }
                    break;
                }case 'c':
                case 'C':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1)){
                        next.setSound("sounds/consenants/c.wav");
                    }if(sentence.charAt(i + 1) == 'h'){
                        // 'ch' sound
                    }else if(sentence.charAt(i + 1) == 'k'){
                        // 'k' or 'ck' sound
                    }else if(sentence.charAt(i + 1) == 'i'){
                        // 's' sound
                    }else{
                        // 'k' sound
                    }
                    
                    
                    break;
                }case 'd':
                case 'D':{
                    //if by itself, say the actual name of the charachter
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/d.wav");
                    }else if(sentence.charAt(i + 1) == 'g'){
                        // 'j' sound
                        i++;
                    }else{//otherwise, say the phonetic pronunciation
                        // 'duh' sound
                    }
                    break;
                }case 'f':
                case 'F':{
                    //if by itself, say the actual name of the charachter
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/f.wav");
                        
                    }else{//otherwise, say the phonetic pronunciation
                        // 'fff' sound
                    }
                    break;
                }case 'g':
                case 'G':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/g.wav");
                    }else if{
                        // 'g' sound
                    }
                    
                    break;
                }case 'h':
                case 'H':{
                    //if by itself, say the actual name of the charachter
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/h.wav");
                        
                    }else{//otherwise, say the phonetic pronunciation
                        // 'h' sound
                    }
                    break;
                }case 'j':
                case 'J':{
                    //if by itself, say the actual name of the charachter
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/j.wav");
                        
                    }else{//otherwise, say the phonetic pronunciation
                        // 'j' sound
                    }
                    break;
                }case 'k':
                case 'K':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i - 1) == ' '){
                        next.setSound("sounds/consenants/k.wav");
                    }else{
                        // 'kuh' sound
                    }
                    
                    break;
                }case 'l':
                case 'L':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/l.wav");
                    }else{
                        // 'l' sound
                    }
                    
                    break;
                }case 'm':
                case 'M':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/m.wav");
                    }else{
                        // 'm' sound
                    }
                    
                    break;
                }case 'n':
                case 'N':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/n.wav");
                    }else{
                        // 'n' sound
                    }
                    break;
                }case 'p':
                case 'P':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/p.wav");
                    }else{
                        // 'p' sound
                    }
                    break;
                }case 'q':
                case 'Q':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/q.wav");
                    }else{
                        // 'q' sound
                    }
                    break;
                }case 'r':
                case 'R':{
                    if(sentence.charAt(i + 1) == ' ' && sentence.charAt(i + 1) == ' '){
                        next.setSound("sounds/consenants/r.wav");
                    }else{
                        // 'r' sound
                    }
                    
                    
                    break;
                }case 's':
                case 'S':{
                    
                    next.setSound("sounds/consenants/s.wav");
                    
                    break;
                }case 't':
                case 'T':{
                    
                    next.setSound("sounds/consenants/t.wav");
                    
                    break;
                }case 'v':
                case 'V':{
                    
                    next.setSound("sounds/consenants/v.wav");
                    
                    break;
                }case 'w':
                case 'W':{
                    
                    next.setSound("sounds/consenants/w.wav");
                    
                    break;
                }case 'x':
                case 'X':{
                    
                    next.setSound("sounds/consenants/x.wav");
                    
                    break;
                }case 'z':
                case 'Z':{
                    
                    next.setSound("sounds/consenants/z.wav");
                    
                    break;
                }case '0':{
                    
                    next.setSound("sounds/numbers/0.wav");
                    
                    break;
                }case '1':{
                    
                    next.setSound("sounds/numbers/1.wav");
                    
                    break;
                }case '2':{
                    
                    next.setSound("sounds/numbers/2.wav");
                    
                    break;
                }case '3':{
                    
                    next.setSound("sounds/numbers/3.wav");
                    
                    break;
                }case '4':{
                    
                    next.setSound("sounds/numbers/4.wav");
                    
                    break;
                }case '5':{
                    
                    next.setSound("sounds/numbers/5.wav");
                    
                    break;
                }case '6':{
                    
                    next.setSound("sounds/numbers/6.wav");
                    
                    break;
                }case '7':{
                    
                    next.setSound("sounds/numbers/7.wav");
                    
                    break;
                }case '8':{
                    
                    next.setSound("sounds/numbers/8.wav");
                    
                    break;
                }case '9':{
                    
                    next.setSound("sounds/numbers/9.wav");
                    
                    break;
                }case '/':{
                    
                    next.setSound("sounds/symbols/fSlash.wav");
                    
                    break;
                }case '\\':{
                    
                    next.setSound("sounds/symbols/bSlash.wav");
                    
                    break;
                }case '&':{
                    
                    next.setSound("sounds/symbols/amp.wav");
                    
                    break;
                }case '#':{
                    
                    next.setSound("sounds/symbols/oct.wav");
                    
                    break;
                }default:{
                    next.setSound("sounds/other/space.wav");
                    break;
                }
                
                
            }//switch case
            System.out.println("Decided which letter to insert and set next's value");
            
            head.setNext(next);
            head = next;
            i++;
            
            
        }//while
        
        //bring head back to first
        head = first;
        
    }//processIt
    
}//voiceComp
