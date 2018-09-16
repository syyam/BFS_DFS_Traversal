package GraphImplementation;


import java.util.*;
import GraphImplementation.Graph;
import GraphImplementation.Graph;
import GraphImplementation.Node;
import static GraphImplementation.Graph.createNewGraph;



public class GraphImplementation 
{

    public int weight=0;
    public int weightBFS=0;
    static String pat="Path doesn't exist.";
            
    public void pathExists(Node node1,Node node2) {
        
        String a=node1.getVertex();
        String b=node2.getVertex();
        Node no=node2;

        
       
        //Avoid infinite loops
        if(node1 == null) return;

       
        node1.state = State.Visited;
        
        for(Node n: node1.getChild())
        {
            if(node1.getVertex().equals(node2.getVertex()))
            {pat="Path exist.";
               
               weight=0; 
               break;        
            }
            if(n.state == State.Unvisited){
                
                weight=weight+1;
                pathExists(n,no); 
            }
           
        }
//        weight+=1;
       return; 
    }
    
    
    public void pathCostDFS(Node node1,Node node2) {
        
        
        String a=node1.getVertex();
        String b=node2.getVertex();
        Node no=node2;
       
        //Avoid infinite loops
        if(node1 == null) return;

       
        node1.state = State.Visited;
        
        for(Node n: node1.getChild())
        {
            if(node1.getVertex().equals(node2.getVertex()))
            {
               System.out.print("weight: "+ weight);
               
               weight=0;
               break;               
            }
            if(n.state == State.Unvisited){
                
                weight=weight+1;
                pathCostDFS(n,no); 
            }
           
        }
//        weight+=1;
        
    }
    
    public void pathCostBFS(Node node1,Node node2) {
        
        Queue<Node> queue = new LinkedList<Node>();

        if(node1 == null) return;

        node1.state = State.Visited;
         //Adds to end of queue
        queue.add(node1);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            node1 = queue.remove(); 
            weightBFS++;

            //Visit child first before grandchild
            for(Node n: node1.getChild())
            {
                if(node1.getVertex().equals(node2.getVertex()))
                {
                   weightBFS =weightBFS-1;
                   System.out.print("weight: "+ weightBFS);
                   weightBFS=0;
                   break;               
                }
                if(n.state == State.Unvisited)
                {
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }
        
    }
    
    public void dfs(Node root)
    {       
        //Avoid infinite loops
        if(root == null) return;

        System.out.print(root.getVertex() + "\t");
        root.state = State.Visited;

        //for every child
        for(Node n: root.getChild())
        {
            
            //if childs state is not visited then recurse
            if(n.state == State.Unvisited)
            {
                dfs(n);
            }
        }
    }

    public void bfs(Node root)
    {
        //Since queue is a interface
        Queue<Node> queue = new LinkedList<Node>();

        if(root == null) return;

        root.state = State.Visited;
         //Adds to end of queue
        queue.add(root);

        while(!queue.isEmpty())
        {
            //removes from front of queue
            root = queue.remove(); 
            System.out.print(root.getVertex() + "\t");

            //Visit child first before grandchild
            for(Node n: root.getChild())
            {
                if(n.state == State.Unvisited)
                {
                    queue.add(n);
                    n.state = State.Visited;
                }
            }
        }


    }

   

    public static void main(String[] args) {

        GraphImplementation s = new GraphImplementation();

        System.out.println("*******************************    DFS    ********************************");
        Graph gDfs = createNewGraph();
        s.dfs(gDfs.getNode()[0]);
        System.out.println();
        System.out.println();
        
        
        System.out.println("*******************************    BFS    ********************************");
        Graph gBfs = createNewGraph();
        s.bfs(gBfs.getNode()[0]);
        
        
        System.out.println();
        System.out.println();
        System.out.println("****************************** pathCostDFS *******************************");
        Graph costDFS = createNewGraph(); 
        s.pathCostDFS(costDFS.getNode()[0], costDFS.getNode()[6]); 
        
        
        System.out.println();
        System.out.println();
        System.out.println("****************************** pathCostBFS *******************************");
        Graph costBFS = createNewGraph(); 
        s.pathCostBFS(costBFS.getNode()[0], costBFS.getNode()[9]); 
        
        
        System.out.println();
        System.out.println();
        System.out.println("****************************** Path Exists *******************************");
        Graph path = createNewGraph(); 
        s.pathExists(path.getNode()[8], path.getNode()[9]); 
        System.out.println(pat);
        
        
    }

    
}
    
