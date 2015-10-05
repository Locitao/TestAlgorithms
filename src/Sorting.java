import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays.*;

/**
 * Created by rvanduijnhoven on 05/10/2015.
 */
public class Sorting{

    private List<Player> players;
    private List<Match> matches;

    public Sorting()
    {
        FillList();
        Player testPlayer = new Player(7916253, 500);
        long time = System.nanoTime();
        Match testMatch = ProcedureAlgorithm(players, testPlayer);
        System.out.println(((System.nanoTime() - time) / 100000) + " Duration of search for a single player in milliseconds without sorting the array.");
        System.out.println(testMatch.toString());
        FillList();
        Collections.sort(players);
        time = System.nanoTime();
        testMatch = ProcedureAlgorithm(players, testPlayer);
        System.out.println(((System.nanoTime() - time) / 100000) + " Duration of search for a single player in milliseconds after sorting the array.");
        System.out.println(testMatch.toString());
        FillList();
        time = System.nanoTime();
        matchAllPlayers(players);
        System.out.println(((System.nanoTime() - time) / 100000) + " Duration of search in milliseconds for all players before sorting array.");
        FillList();
        Collections.sort(players);
        time = System.nanoTime();
        matchAllPlayers(players);
        System.out.println(((System.nanoTime() - time) / 100000) + " Duration of search in milliseconds for all players after sorting array.");

    }

    public void FillList()
    {
        players = new ArrayList<>();

        for (int i = 0; i <= 100000; i++)
        {
            int randomElo = ThreadLocalRandom.current().nextInt(1, 1001);
            Player p = new Player(i, randomElo);
            players.add(p);
            i++;
        }
    }

    public Match ProcedureAlgorithm(List<Player> players, Player p)
    {

        Match bestMatch = null;
        int score = 100;
        int tempScore;

        for (Player pl : players)
        {
            if (pl.getElo() == p.getElo() && !pl.inMatch && !p.inMatch)
            {
                bestMatch = new Match(p, pl);
                return bestMatch;
            }

            if (pl.getElo() < p.getElo() && !pl.inMatch && !p.inMatch)
            {
                tempScore = p.getElo() - pl.getElo();
                if (tempScore < score)
                {
                    bestMatch = new Match(p, pl);
                }
            }

            if (pl.getElo() > p.getElo() && !pl.inMatch && !p.inMatch)
            {
                tempScore = pl.getElo() - p.getElo();
                if (tempScore < score)
                {
                    bestMatch = new Match(p, pl);
                }
            }
        }

        return bestMatch;
    }

    public void matchAllPlayers(List<Player> players)
    {
        for (Iterator<Player> it = players.iterator(); it.hasNext();)
        {
            Player p = it.next();

            Match newMatch = ProcedureAlgorithm(players, p);
            Player p1 = newMatch.getP1();
            Player p2 = newMatch.getP2();
            p1.inMatch = true;
            p2.inMatch = true;

        }
    }



}
