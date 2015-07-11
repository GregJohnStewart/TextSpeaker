/* LL node object for sound files
 * 
 * 
 * Author: Greg Stewart
 * Start: 4/23/14
 * 
 */

//for testing file existence
java.nio.file.Files

//package TextSpeaker;
public class SpeechNode{
    
    //////////////////////////
    //  Instance Variables  //
    //////////////////////////
    
    //the actual sound I hold
    private Sound mySound;
    
	//the sound I represent (a, b, etc)
	private String myValue;
    
	//the type of sound
	/*
		
	*/
	private String type;
	
	//the sound pack
	private String sp;
	
	
	//
	// other variables
	//
	
	// where the sound packs are located
	private String packsDir = "sounds/";
    
    ////////////////////
    //  Constructors  //
    ////////////////////
    
    /*
		sets the correct value
		
		myValue = what the node represents phonetically
		ls = 'long/short/whole', used where applicable
			- long - a long vowel sound
			- short - a short vowel sound
			- does not apply to consonants
		sp = 'sound pack', specifies which sounds to use
	*/
    public SpeechNode(char inValue,char ls,String sp){
		//set the value
		setValue(inValue);
		
		if(sp != null){
			setPack(sp);
		}else{
			setPack("default");
		}
		
		//find out what kind of character
		setType(ls);
		
		//set appropriate sound
		setSound(inValue);
		
    }//SpeechNode(char,char)
    
    //setting the node without any input, simply making it a space
    public SpeechNode(){
		if(this.sp == null){
			this.sp == "default";
		}
        setSound("sounds/" + this.sp + "/other/space.wav");
		this.myValue = " ";
		this.type = "s";
    }
    
    
    
    ///////////////
    //  Setters  //
    ///////////////
	
	//set the value of the charachter
	public void setValue(String inVal){
		//test if a one charachtrer string
		if(inVal.length() == 1){
			//move value to a charachter
			char inChar = inVal.charAt(0);
			
			//if a letter, 
			if(inChar.isLetter){
				inChar = toLowerCase(inChar).charAt(0);
			}else{
				
			}
		}else{
			
		}
	}//setValue
	
	//set the correct types n such
	public void setType(char ls){
		if(Charachter.isLetter(myValue)){
			if(ls != null && (myValue == 'a' || myValue == 'e' || myValue == 'i' || myValue == 'o' || myValue == 'u')){
				if(ls == 'l'){
					this.type = "vl";
				}else if(ls == "s"){
					this.type = "vs";
				}
			}else{
				this.type = "c";
			}
		}else{
			if(myValue == ' '){
				this.type = "sp";
			}else{
				this.type = "sc";
			}
		}
	}//setType
	
	public void setPack(String packIn){
		//check if null, if so, set to default
		if(packIn == null){
			packIn = "default";
		}
		//build path
		Path path = packsDir + packIn + "/";
		
		//check if path exists. If doesn't, set to default
		if (Files.notExists(path)) {
			if(packIn == "default"){
				//throw exception, no default
			}else{
				setPack(null);
			}
		}else{
			this.sp = packIn;
		}
	}//setPack
	
    //set the sound with a source
    private void setSound(){
		String loc = packsDir + sp + "/";
		
		//test the  character and type and set appropriately
		
		
		
        this.mySound = new Sound(loc);
    }//setSound
    
    
    ///////////////
    //  getters  //
    ///////////////
    
    //to get the sound object
    public Sound getSound(){
        return mySound;
    }
    
    //to play the sound
    public void play(){
        mySound.playSound();
    }
    
    //////////////////////
    //  worker classes  //
    //////////////////////
	
	private String toLowerCase (String inputVal) {
		// Empty strings should be returned as-is.
		if (inputVal.length() == 0){
			return "";
		}
		
		// Strings with only one character uppercased.
		if (inputVal.length() == 1){
			return inputVal.toUpperCase();
		}

		// Otherwise uppercase first letter, lowercase the rest.
		return inputVal.substring(0,1).toUpperCase()
			+ inputVal.substring(1).toLowerCase();
	}//toLowerCase
        
}//SpeechNode


















