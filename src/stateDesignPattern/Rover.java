package stateDesignPattern;

/**
 * Rover class with methods using state pattern
 * @author Chitra
 * @version v2024.04
 */
public class Rover {
	
	   protected State currentState = new AtRest();

	   /**
	    * default constructor
	    */
	    public Rover() {}

	    /**method for Right pedal press
	     * 
	     * @param numOfTimesPressed
	     */
	    protected void pressRightPedal(int numOfTimesPressed) {
	        Boolean move;
	        switch (this.currentState.name) {
	            case "At Rest":
	                move = this.currentState.pressRightPedal(numOfTimesPressed);
	                if(move){ // no error
	                    this.currentState = new MoveForward(); // current state becomes state MoveForward
	                }
	                break;
	            case "Move Forward":
	                move = this.currentState.pressRightPedal(numOfTimesPressed);
	                // current state only changes to At Rest State if numOfTimesPressed is 3
	                if(move) {
	                    this.currentState = new AtRest();
	                }
	                break;
	            default:
	                System.out.println("Error: Can only press Right Pedal when in At Rest or inside Move Forward States.\nUnable to move.");
	                break;
	        }
	    }

	    /**
	     * method for right pedal press for specific number of seconds
	     * @param numOfSecondsPressed
	     */
	    protected void pressRightPedalForTime(int numOfSecondsPressed) {
	        if(this.currentState.name == "Move Backward" || this.currentState.name == "At Rest") {
	            System.out.println("Error: Can only press Right Pedal for Time when inside Move Forward State.\nUnable to move.");
	            return;
	        }
	        this.currentState.pressRightPedalForTime(numOfSecondsPressed);
	    }

	    /**
	     * method for left pedal press
	     * @param numOfTimesPressed
	     */
	    protected void pressLeftPedal(int numOfTimesPressed) {
	        if(this.currentState.name == "Move Forward" || this.currentState.name == "At Rest") {
	            System.out.println("Error: Can only press Left Pedal when inside Move Backward State.\nUnable to move.");
	            return;
	        }
	        Boolean move = this.currentState.pressLeftPedal(numOfTimesPressed);
	        // current state only changes to At Rest State if numOfTimesPressed is 3
	        if(move) {
	            this.currentState = new AtRest();
	        }
	    }

	    /**
	     * method for left pedal press for specific number of seconds
	     * @param numOfSecondsPressed
	     */
	    protected void pressLeftPedalForTime(int numOfSecondsPressed) {
	        switch (this.currentState.name) {
	            case "At Rest":
	                Boolean move = this.currentState.pressLeftPedalForTime(numOfSecondsPressed);
	                if(move) { // no error
	                    this.currentState = new MoveBackward(); // current state becomes state MoveBackward
	                }
	                break;
	            case "Move Backward":
	                this.currentState.voidPressLeftPedalForTime(numOfSecondsPressed);
	                break;
	            default:
	                System.out.println("Error: Can only press Left Pedal for Time when in At Rest or inside Move Backward States.\nUnable to move.");
	                break;
	        }
	    }

	    /**
	     * method to print state and sub state
	     */
	    protected void printStateAndSubState() {
	        System.out.println("Current State: " + this.currentState.name);
	        System.out.println("Current SubState: " + this.currentState.subState);
	    }

	    public static void main(String[] args) {

	    }
}
