package cygni;

/**
 * A container-class for when a certain player makes a certain move.
 * @author Coyote
 */
public class PlayerMove{

	private String name;
	private String move;
	
	/**
	 * Empty constructor. Necessary for constructing a playermove based on a JSON-definition.
	 */
	public PlayerMove(){}
	
	/**
	 * Constructs a playermove based on the parameters.
	 * @param name The name of the player making the move.
	 * @param move The move made by the player.
	 */
	public PlayerMove(String name, String move){
		this.name = name;
		this.move = move;
	}
	
    /**
	 * Getter for the name.
     * @return The name of the player making the move.
     */
	public String getName(){
		return this.name;
	}

    /**
	 * Getter for the move.
     * @return The move made.
     */	
	public String getMove(){
		return this.move;
	}
}