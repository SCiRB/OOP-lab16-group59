package th.ac.cmu.GroupIL;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class Controller {
    @Autowired
    private PlayerService playerService;
    @GetMapping("/")
    public String helloWorld(){
        return "Hello I'm Lica";
    }
    @PostMapping("/player")
    public Player createPlayer(@RequestBody String body){
        return this.playerService.createNewPlayer(body);
    }

    @GetMapping("/gohome/{name}")
    public String goHome(@PathVariable("name") String name ){
        if (name.equals("P")) return null ;
        else if(name.equals("Chin")) return "CPE" ;
        return  "Google Maps!" ;
    }
    @GetMapping("/player/{name}")
    public ResponseEntity<Player> GetPlayerInfo(@PathVariable("name") String name){
        Player player = this.playerService.GetPlayerFromName(name);
        if(player == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(player, HttpStatus.OK);
        }
    }
    @PutMapping("/player/{name}")
    public ResponseEntity<Player> IncreasePlayerCount(@PathVariable("name") String name){
        Player player = this.playerService.IncreaseClickCount(name);
        if(player == null){//No player exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//return error
        } else {
            return new ResponseEntity<>(player, HttpStatus.OK);//if player is exist, allow click
        }
    }
    @GetMapping("/player/leaderboard")
    public Collection<Player> GetLeaderboard(){
        return this.playerService.GetLeaderboard();
    }
    @GetMapping("/players")
    public Collection<Player> GetAllPlayers() {
        return playerService.GetLeaderboard();
    }
}

//please pushable