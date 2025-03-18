import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Integer, Map<Artists, Integer>> nbMentionDArtistesParArtiste;

    public Graph(String listeArtsites, String listeMentions) {
        nbMentionDArtistesParArtiste = new HashMap<Integer, Map<Artists, Integer>>();
    }
}
