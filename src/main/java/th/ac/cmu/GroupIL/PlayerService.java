package th.ac.cmu.GroupIL;

import java.util.Collection;

import java.util.Collection;

public interface PlayerService {
    public  Player createNewPlayer(String name) ;

    Player GetPlayerFromName(String name);

    Player IncreaseClickCount(String name);

    Collection<Player> GetLeaderboard();
}

//comment use to push