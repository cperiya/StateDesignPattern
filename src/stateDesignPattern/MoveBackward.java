package stateDesignPattern;

/**
 * class for state MoveBackward and associated methods
 * @author Chitra
 * @version v2024.04 
 */
public class MoveBackward extends State {
	
	/**
	 * default constructor
	 */
	 MoveBackward() {
	        this.name = "Move Backward";
	        this.subState = "Accelerate";
	    }

	 /** method for left pedal press
	  * @param numOfTimesPressed number of times pressed
	  * @return Boolean true or false
	  */
	    protected Boolean pressLeftPedal(int numOfTimesPressed) {
	        Boolean move = false;
	        switch (numOfTimesPressed) {
	            case 1:
	                if(this.subState != "Decelerate" && this.subState != "Constant Speed") {
	                    System.out.println("Error: Can only press Left Pedal once when in Constant Speed or Decelerate States.\nUnable to move.");
	                } else if(this.subState == "Decelerate") {
	                    System.out.println("Transitioning from Decelerate State to Constant Speed State...");
	                    this.subState = "Constant Speed";
	                } else {
	                    System.out.println("Transitioning from Constant Speed State to Decelerate State...");
	                    this.subState = "Decelerate";
	                }
	                break;
	            case 2:
	                if(this.subState != "Decelerate" && this.subState != "Accelerate") {
	                    System.out.println("Error: Can only press Left Pedal twice when in Accelerate or Decelerate States.\nUnable to move.");
	                } else if(this.subState == "Decelerate") {
	                    System.out.println("Transitioning from Decelerate State to Accelerate State...");
	                    this.subState = "Accelerate";
	                } else {
	                    System.out.println("Transitioning from Accelerate State to Decelerate State...");
	                    this.subState = "Decelerate";
	                }
	                break;
	            case 3:
	                if(this.subState != "Decelerate") {
	                    System.out.println("Error: Can only press Left Pedal thrice when in Decelerate State.\nUnable to move.");
	                } else {
	                    System.out.println("Transitioning from Decelerate State to At Rest State...");
	                    this.subState = null;
	                    move = true;
	                }
	                break;
	            default:
	                System.out.println("Error: Must press Left Pedal once, twice, or thrice when in Move Backward State.\nUnable to move.");
	                break;
	        }
	        return move;
	    }

	    /** method for left pedal pressed fro specific time
	     * @param numOfSecondsPressed number of seconds pressed
	     */
	    protected void voidPressLeftPedalForTime(int numOfSecondsPressed) {
	        if(numOfSecondsPressed != 3) {
	            System.out.println("Error: Can only press Left Pedal for 3 seconds when in Accelerate or Constant Speed States to move.\nUnable to move.");
	            return;
	        }
	        if(this.subState != "Accelerate" && this.subState != "Constant Speed") {
	            System.out.println("Error: Can only press Left Pedal for 3 seconds when in Accelerate or Constant Speed States.\nUnable to move.");
	            return;
	        }
	        if(this.subState == "Accelerate") {
	            System.out.println("Transitioning from Accelerate State to Constant Speed State...");
	            this.subState = "Constant Speed";
	            return;
	        }
	        System.out.println("Transitioning from Constant Speed State to Accelerate State...");
	        this.subState = "Accelerate";
	    }

}
