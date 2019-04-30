package cygni;

/**
 * A representation of a game of rock-paper-scissor with two players.
 * @author Coyote
 */
public class Game {

    private final Long id;
    private final String creatorName;
	private String creatorMove;
	private String joinerName;
	private String joinerMove;
	private final String[] moves = {"rock", "paper", "scissor"};
	
	/**
	 * Constructs a game based on the parameters.
	 * @param id The id of the game.
	 * @param creatorName The name of the player creating the game.
	 */
    Game(Long id, String creatorName) {
        this.id = id;
        this.creatorName = creatorName;
    }
	
	/**
	 * Constructs a game based on the parameters.
	 * @param id The id of the game.
	 * @param creatorName The name of the player creating the game.
	 * @param joinerName The name of the player who has joined the game.
	 */
    Game(Long id, String creatorName, String joinerName) {
        this.id = id;
        this.creatorName = creatorName;
		this.joinerName = joinerName;
    }

    /**
	 * Getter for the id.
     * @return The id of the game.
     */
    public Long getId() {
        return id;
    }

    /**
	 * Getter for the name of the creator.
     * @return The name of the player who created the game.
     */
    public String getCreatorName() {
        return creatorName;
    }
	
    /**
	 * Getter for the move made by the creator.
     * @return The move made by the creator.
     */
	public String getCreatorMove(){
		return creatorMove;
	}
	
    /**
	 * Getter for the name of the player who has joined the game.
     * @return The name of the player who has joined the game.
     */
	public String getJoinerName() {
        return joinerName;
    }
	
    /**
	 * Getter for the move made by the player who joined the game.
     * @return The move made by the player who joined the game.
     */
	public String getJoinerMove(){
		return joinerMove;
	}

    /**
	 * Adds a player to the game unless there already is a player who has joined or the new player does not have a name.
     * @param joinerName The name of the new player.
     */	
	boolean addPlayer(String joinerName){
		if(this.joinerName == null && joinerName != null){
			this.joinerName = joinerName;
			return true;
		}
		return false;
	}
	
    /**
	 * Registers a move made by a player.
     * @param pm The move made by a specific player.
	 * @return True if the move was completed, otherwise false.
     */	
	boolean makeMove(PlayerMove pm){
		if(!this.finished()){
			String player = pm.getName();
			String move = pm.getMove();
			if(player != null){
				if(this.validMove(move)){
					if(player.equalsIgnoreCase(creatorName)){
						creatorMove = move;
						return true;
					}else if(player.equalsIgnoreCase(joinerName)){
						joinerMove = move;
						return true;
					}
				}
			}
		}
		return false;
	}
	
    /**
	 * Checks whether a move is valid or not.
     * @param move The move to be checked.
	 * @return Returns true if it is a valid move, otherwise false.
     */	
	private boolean validMove(String move){
		if(move == null)
			return false;
		for(String m : moves){
			if(move.equalsIgnoreCase(m))
				return true;
		}
		return false;
	}

    /**
	 * Checks whether this game is finished or not.
	 * @return Returns true if both players of this game has made their moves, otherwise false.
     */		
	boolean finished(){
		if(creatorMove != null && joinerMove != null){
			return true;
		}else{
			return false;
		}
	}
}