import java.util.ArrayList;

/**
 * Created by Admin on 2014-11-15.
 */
public class Graph {
    protected ArrayList<ArrayList<Integer>> graph;
    public Graph()
    {
        graph= new ArrayList<ArrayList<Integer>>();
    }
    ArrayList<ArrayList<Integer>> getGraph()
    {
        return graph;
    }
    public void readAdjacencyMatrix (ArrayList<ArrayList<Integer>> matrix)
    {
        graph=new ArrayList<ArrayList<Integer>>(matrix);
    }
    public ArrayList<Integer> getAdjacentNodes(int act)
    {
        return graph.get(act);
    }
    @Override
    public String toString()
    {
        String tablica = new String("");
        for (int i=0;i<graph.size();i++)
        {
            tablica+=graph.get(i).toString();
            tablica+='\n';
        }
        return tablica;
    }
}
