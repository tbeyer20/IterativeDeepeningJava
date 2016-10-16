package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class IterativeDeepening {

    boolean[] visited = new boolean[5];
//My apologies for hard coded path... :(
    String pathToTextFile = "/home/tb20/workspace/algorithms/";
    int[][] adjacecnyMatrix = new int[5][5];
    Stack<nodes> myStack;
    
    public static void main(String[] args) throws IOException {

        IterativeDeepening thisProgram = new IterativeDeepening();
        /*
         * Read Text File
         */
        thisProgram.readInput();

        /*
         * Use DFS search
         */
        int myMaxSearchDepth = 3;
        int currentSearchDepth = 0;
        while (currentSearchDepth <= myMaxSearchDepth) {
            thisProgram.iterDeepening(currentSearchDepth);
            currentSearchDepth++;
            thisProgram.clearBoolean();
            System.out.println();
        }
    }
    // }

    public void readInput() throws IOException {
        BufferedReader input = new BufferedReader(new FileReader(pathToTextFile + "input.txt"));
        String txtFieldLine = input.readLine();
        while (txtFieldLine != null) {
            for (int i = 0; i < 5; i++) {
                String[] num = txtFieldLine.split(",");
                
                adjacecnyMatrix[i][0] = Integer.parseInt(num[0]);
                adjacecnyMatrix[i][1] = Integer.parseInt(num[1]);
                adjacecnyMatrix[i][2] = Integer.parseInt(num[2]);
                adjacecnyMatrix[i][3] = Integer.parseInt(num[3]);
                adjacecnyMatrix[i][4] = Integer.parseInt(num[4]);

                txtFieldLine = input.readLine();
            }
        }
        input.close();
    }

    public int getChild(int i) {
        for (int j = 0; j < 5; j++) {
            if (adjacecnyMatrix[i][j] == 1 && !visited[j]) {
                return j;
            }
        }
        return -1;
    }

    public void iterDeepening(int maxSearchDepth) {
        Stack<nodes> myStack = new Stack<nodes>();

        // Root Node
        int currentDepth = 0;
        nodes rootNode = new nodes(0);
        myStack.push(rootNode);
        visited[0] = true;
        System.out.println(rootNode.printName());

        while (!myStack.isEmpty() ) {
            int child;
            int n;
            n = myStack.peek().getVertexNum();
            child = getChild(n);

            if (child != -1 && (currentDepth < maxSearchDepth)) {
                visited[child] = true;
                nodes myNode = new nodes(child);
                System.out.println(myNode.printName());
                myStack.push(myNode);
                currentDepth ++;
            } else {
                // Go back up the stack
                myStack.pop();
                currentDepth--;
            }
        }
    }

    public void clearBoolean() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }
}
