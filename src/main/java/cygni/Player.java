package cygni;

/**
 * Represents a player.
 * @author Coyote
 */
public class Player{

	private String name;
	
	/**
	 * Empty constructor. Necessary for constructing a player based on a JSON-definition.
	 */
	public Player(){}
	
	/**
	 * Constructs a player based on the parameters.
	 * @param name The name of the player.
	 */
	public Player(String name){
		this.name = name;
	}
	
    /**
	 * Getter for the name.
     * @return The name of the player.
     */
	public String getName(){
		return name;
	}
}