package th.ac.cmu.GroupIL;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PlayerRepo implements PlayerService {
    private Map<String, Player> map = new HashMap<>();

    @Override
    public Player createNewPlayer(String name) {
        if (map.containsKey(name)) {
            return map.get(name);
        }
        Player player = new Player(name);
        map.put(name, player);
        return player;
    }

    @Override
    public Player GetPlayerFromName(String name) {
        return map.get(name);
    }

    @Override
    public Player IncreaseClickCount(String name) {
        if (map.containsKey(name)) {
            Player player = map.get(name);
            player.clicked++;
            return player;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Player> GetLeaderboard() {
        return map.values();
    }
}

//comment use to push