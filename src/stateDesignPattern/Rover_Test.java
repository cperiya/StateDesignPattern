package stateDesignPattern;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * class with test cases for rover states
 * @author Chitra
 * @version v2024.04
 */
class Rover_Test {

	/**
	 * method when right pedal is pressed once
	 */
	@Test
	public void pressRightPedal_test() {
		Rover rover = new Rover();
		//start state - "At Rest" 
        assertEquals("At Rest",rover.currentState.name);
        
        // When at rest, pressing right pedal twice, rover should not move 
        rover.pressRightPedal(2);
        assertEquals("At Rest",rover.currentState.name);
        
        //When at rest, pressing right pedal one time, rover should move  forward
        rover.pressRightPedal(1);
        assertEquals("Move Forward",rover.currentState.name);
	}
	
	/**
	 * method for right pedal press for specific time
	 */
	@Test
    public void PressRightPedalForTime_test() {
		Rover rover = new Rover();
        //when inside Move Forward State but not At Rest state.
		rover.pressRightPedalForTime(3);
        assertEquals("At Rest",rover.currentState.name);
        
        //from At Rest State to Move Forward State 
        rover.pressRightPedal(1);
        assertEquals("Move Forward",rover.currentState.name);
        
        //When pressed right pedal for 5 secs, change from Accelerate State to Constant Speed State
        rover.pressRightPedalForTime(5);
        assertEquals("Constant Speed",rover.currentState.subState);
        
        // When pressed right pedal for 3 secs, change from Constant Speed subState to decelerate subState
        rover.pressRightPedalForTime(3);
        assertEquals("Decelerate",rover.currentState.subState);       
        
    }
	
	/**
     * method Left pedal press
     */
    @Test
    public void PressLeftPedal_test() {
    	Rover rover = new Rover();
        //Left pedal used to Move Backward
    	rover.pressLeftPedal(1);
        assertEquals("At Rest",rover.currentState.name);
        
        //change from Move Backward by pressing it for 5 secs
        rover.pressLeftPedalForTime(5);
        assertEquals("Move Backward", rover.currentState.name);
        
        //Left pedal when pressed in Move Backward state, rover changes from Accelerate State to Decelerate State
        rover.pressLeftPedal(2);
        assertEquals("Decelerate",rover.currentState.subState);
        
        //Left pedal when pressed in Decelerate State, rover changes from Decelerate State to Constant Speed State
        rover.pressLeftPedal(1);
        assertEquals("Constant Speed",rover.currentState.subState);       
    }

    /**
     * method for Left Pedal  press for specific time
     */
    @Test
    public void PressLeftPedalForTime_test() {
    	Rover rover = new Rover();
        //Rover starts from "At Rest" state
        assertEquals("At Rest",rover.currentState.name);
        
        //When at rest, pressing left pedal for 5 secs
        rover.pressLeftPedalForTime(5);
        assertEquals("Move Backward",rover.currentState.name);
        
        //When at Move Backward state, pressing left pedal for 3 secs to move rover in constant backward speed State
        rover.pressLeftPedalForTime(3);
        assertEquals("Constant Speed",rover.currentState.subState);
        
        //When at Move Backward state, pressing left pedal for 3 secs to accelerate the rover in forward direction
        rover.pressLeftPedalForTime(3);
        assertEquals("Accelerate",rover.currentState.subState);
        
    }


}
