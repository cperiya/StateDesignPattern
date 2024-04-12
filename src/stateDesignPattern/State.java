package stateDesignPattern;

/** State class
 * @author Chitra
 * @version v2024.04
 */
public class State {
	
	
    protected String name = "NULL";
    protected String subState = "NULL";

    /** default constructor
     */
    public State() {}
    
    /** 
     * Press right pedal 
     * @param numOfTimesPressed - Use to get how many times pressed
     * @return boolean
     */
    public Boolean pressRightPedal(int numOfTimesPressed) {
        return false;
    }
    
    
    /** 
     * Press right pedal for specific seconds
     * @param pressRightPedalForTime Use to get how many times pressed
     * 
     */
    protected void pressRightPedalForTime(int numOfSecondsPressed) {}

    /**press left pedal
     * @param numOfTimesPressed
     * @return false
     */
    protected Boolean pressLeftPedal(int numOfTimesPressed) {
        return false;
    }

    /**
     * press left pedal for specific number of seconds
     * @param numOfSecondsPressed
     * @return false
     */
    protected Boolean pressLeftPedalForTime(int numOfSecondsPressed) {
        return false;
    }

    /**
     * press left pedal for specific seconds
     * @param numOfSecondsPressed
     */
    protected void voidPressLeftPedalForTime(int numOfSecondsPressed) {}

}
