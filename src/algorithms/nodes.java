package algorithms;


public class nodes {
    boolean visited;
    String nameOfVertex;
    public int vertexNum;
    
    public nodes(int vertexName) {
        vertexNum = vertexName;
        switch (vertexName) {
        case 0:
            nameOfVertex = "A";
            break;
        case 1:
            nameOfVertex = "B";
            break;
        case 2:
            nameOfVertex = "C";
            break;
        case 3:
            nameOfVertex = "D";
            break;
        case 4: 
        	nameOfVertex = "E";
        	break;
        default:
            nameOfVertex = "empty";
        }
    }

    public int getVertexNum(){
        return vertexNum;
    }
    
    public String printName() {
        return nameOfVertex;
    }

    public boolean hasBeenVisited() {
        return visited;
    }

}