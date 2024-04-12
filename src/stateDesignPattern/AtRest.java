package stateDesignPattern;

/**
 * Class with method calls for at Rest state
 * @author Chitra
 * @version v2024.04
 */
public class AtRest extends State{
	
	/**
	 * default constructor with name and substate initialized 
	 */
	AtRest() {
        this.name = "At Rest";
        this.subState = "None";
    }

	/**
	 * method called when right pedal is pressed for specific time
	 * @param numOfTimesPressed number of times right pedal pressed
	 * @return boolVal 
	 */
    public Boolean pressRightPedal(int numOfTimesPressed) {
    	Boolean boolVal = false;
        if(numOfTimesPressed != 1) {
            System.out.println("Error: Can only press Right Pedal once when in At Rest State.\nUnable to move.");
            boolVal = false;
            //return false;
        } else {
            System.out.println("Transitioning from At Rest State to Move Forward State...");
            boolVal = true;
            //return true;
        }
        return boolVal;
    }

    /**
     * method called when left pedal is pressed for specific number of seconds 
     * @param numOfSecondsPressed number of seconds left pedal is pressed
     * @return Boolean
     */
    protected Boolean pressLeftPedalForTime(int numOfSecondsPressed) {
        if(numOfSecondsPressed != 5) {
            System.out.println("Error: Must press Right Pedal for 5 seconds when in At Rest State.\nUnable to move.");
            return false;
        } else {
            System.out.println("Transitioning from At Rest State to Move Backward State...");
            return true;
        }
    }

}
