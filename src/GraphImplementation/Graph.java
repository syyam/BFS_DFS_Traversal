
package GraphImplementation;

public class Graph {

    public int count; // number of vertices
    private Node vertices[];

    public Graph()
    {
        vertices = new Node[11];
        count = 0;
    }

    public void addNode(Node n)
    {
            vertices[count] = n;
            count++;
       
    }

    public Node[] getNode()
    {
        return vertices;
    }

    public static Graph createNewGraph()
    {
        Graph g = new Graph();        
        Node[] N = new Node[10];

        // Creating Nodes
        N[0] = new Node("A", 3);
        N[1] = new Node("B", 3);
        N[2] = new Node("C", 1);
        N[3] = new Node("D", 1);
        N[4] = new Node("E", 3);
        N[5] = new Node("F", 3);
        N[6] = new Node("G", 1);
        N[7] = new Node("H", 2);
        N[8] = new Node("I", 2);
        N[9] = new Node("J", 1);

        
        // Making relations
        N[0].addChildNode(N[1]);
        N[0].addChildNode(N[2]);
        N[0].addChildNode(N[3]);

        N[1].addChildNode(N[0]);
        N[1].addChildNode(N[4]);
        N[1].addChildNode(N[5]);


        N[2].addChildNode(N[0]);
        
        N[3].addChildNode(N[0]);
        
        N[4].addChildNode(N[0]);
        N[4].addChildNode(N[6]);
        N[4].addChildNode(N[7]);
        
        N[5].addChildNode(N[1]);
        N[5].addChildNode(N[7]);
        N[5].addChildNode(N[8]);
        
        N[6].addChildNode(N[4]);
        
        N[7].addChildNode(N[6]);
        N[7].addChildNode(N[8]);
        
        N[8].addChildNode(N[9]);
        N[8].addChildNode(N[7]);
        
        
        N[9].addChildNode(N[9]);
        
        for (int i = 0; i < 10; i++) 
        {
            g.addNode(N[i]);
        }
        return g;
    }
}