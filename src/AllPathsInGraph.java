import java.util.ArrayList;

/**
 * Created by Admin on 2014-11-28.
 */
public class AllPathsInGraph extends Graph {
    private int finishNode;
    private ArrayList<ArrayList<Integer>> paths;
    private ArrayList<Integer> visited;

    public AllPathsInGraph()
    {
        super();
        paths = new ArrayList<ArrayList<Integer>>();
        visited= new ArrayList<Integer>();
        finishNode=0;
    }
    private void DFS(int act)
    {
        ArrayList<Integer> adjacentNodes=graph.get(act);
        for(Integer node:adjacentNodes)
        {
            if(wasVisited(node))
                continue;
            if(isFinishNode(node))
            {
                visited.add(node);
                addPath();
                visited.remove(visited.size()-1);
                break;
            }
        }
        for(Integer node:adjacentNodes)
        {
            if(wasVisited(node) || isFinishNode(node))
                continue;
            visited.add(node);
            DFS(node);
            visited.remove(visited.size()-1);
        }
    }
    public void calculateAllPaths(int startNode,int finishNode)
    {
        this.finishNode=finishNode;
        visited.add(startNode);
        DFS(startNode);
    }
    private void addPath() {
        paths.add(new ArrayList<Integer>(visited));
    }

    public ArrayList<ArrayList<Integer>> getPaths() {
        return paths;
    }

    private boolean isFinishNode(Integer i) {
        return i.equals(finishNode);
    }
    private boolean wasVisited(Integer i)
    {
        return visited.contains(i);
    }

    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>>temp=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<7;i++)
        {
            temp.add(new ArrayList<Integer>());
        }


        temp.get(0).add(1);
        temp.get(1).add(0);
        temp.get(0).add(2);
        temp.get(2).add(0);
        temp.get(3).add(0);
        temp.get(0).add(3);
        temp.get(3).add(1);
        temp.get(1).add(3);
        temp.get(3).add(2);
        temp.get(2).add(3);
        temp.get(4).add(2);
        temp.get(2).add(4);
        temp.get(5).add(3);
        temp.get(3).add(5);
        temp.get(4).add(6);
        temp.get(6).add(4);
        AllPathsInGraph paths = new AllPathsInGraph();
        paths.readAdjacencyMatrix(temp);
        System.out.println(paths.toString());
        paths.calculateAllPaths(0,6);
        System.out.println(paths.getPaths().toString());

    }
}
