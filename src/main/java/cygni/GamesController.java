package cygni;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.concurrent.atomic.AtomicLong;
import java.util.HashMap;


/**
 * The class that handles the calls made to the rock-paper-scissor-API.
 * @author Coyote
 */
@RestController
@RequestMapping("/api")
public class GamesController {

    private AtomicLong counter = new AtomicLong();
	private HashMap<Long, Game> games = new HashMap<Long, Game>();


    /**
	 * Accessible at POST /api/games. Creates a new game with the specified player as its creator.
     * @param creator The creator of the game.
	 * @return Returns the id of the new game.
     */	
    @PostMapping("/games")
    public ResponseEntity<Long> createGame(@RequestBody Player creator) {
		String name = creator.getName();
		if(name != null){
			Long id = new Long(counter.incrementAndGet());
			Game newGame = new Game(id, name);
			games.put(id, newGame);
			return ResponseEntity.ok(id);
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }

    /**
	 * Accessible at POST /api/games/{id}/join. Joins the specified player to the specified game.
	 * @param id The id of the game.
     * @param joiner The player who wants to join the game.
	 * @return A HTTP-response.
     */
    @PostMapping("/games/{id}/join")
    public ResponseEntity<String> joinGame(@PathVariable Long id, @RequestBody Player joiner) {
		String name = joiner.getName();
		if(games.containsKey(id)){
			Game game = games.get(id);
			if(game.addPlayer(name)){
				return ResponseEntity.ok(null);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
	
	/**
	 * Accessible at POST /api/games/{id}/move. Updates the game with the specified move for the player.
	 * @param id The id of the game.
     * @param move The move made by the specified player.
	 * @return A HTTP-response.
     */
    @PostMapping("/games/{id}/move")
    public ResponseEntity<String> makeMove(@PathVariable Long id, @RequestBody PlayerMove move) {
		if(games.containsKey(id)){
			Game game = games.get(id);
			if(game.makeMove(move)){
				return ResponseEntity.ok(null);
			}
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
	
    /**
	 * Accessible at GET /api/games/{id}. Shows the state of the game.
     * @param id The id of the game.
	 * @return Returns the state of the game.
     */	
    @GetMapping("/games/{id}")
    public ResponseEntity<Game> game(@PathVariable Long id) {
		if(games.containsKey(id)){
			Game game = games.get(id);
			if(game.finished())
				return ResponseEntity.ok(game);
			else{
				String creator = game.getCreatorName();
				String joiner = game.getJoinerName();
				Game returGame = new Game(id, creator, joiner);
				return ResponseEntity.ok(returGame);
			}
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
    }
}