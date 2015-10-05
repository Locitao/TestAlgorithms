import java.util.Comparator;
import java.util.Collections;

/**
 * Created by rvanduijnhoven on 05/10/2015.
 */
public class Player implements Comparable<Player> {
    private int id;
    private int elo;
    public boolean inMatch;

    public Player(int id, int elo)
    {
        this.id = id;
        this.elo = elo;
        this.inMatch = false;
    }

    @Override
    public String toString()
    {
        String str = "ID: " + id + ", elo: " + elo + ".";
        return str;
    }

    public int getElo()
    {
        return elo;
    }

    public int compareTo(Player other)
    {
        return Integer.compare(this.elo, other.elo);
    }

}
