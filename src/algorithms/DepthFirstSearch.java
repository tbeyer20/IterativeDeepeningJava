package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class DepthFirstSearch {

	boolean[] visited = new boolean[5];
//Once again, hard coded path = not good
	String pathToTextFile = "/home/tb20/workspace/";
	Stack<nodes> DFS = new Stack<nodes>();
	int[][] adjacencyMatrix = new int[5][5];

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		DepthFirstSearch matrix = new DepthFirstSearch();
		/*
		 * Read Text File
		 */
		matrix.readInput();

		/*
		 * Use DFS search
		 */
		matrix.dfs(0);
	}

	public void dfs(int i) {
		// Root Node
		nodes rootNode = new nodes(0);
		DFS.push(rootNode);
		visited[0] = true;
		System.out.println(rootNode.printName());

		while (!DFS.isEmpty()) {
			int child;
			int n;
			n = DFS.peek().getVertexNum();
			child = getChild(n);

			if (child != -1) {
				visited[child] = true;
				nodes myNode = new nodes(child);
				System.out.println(myNode.printName());
				DFS.push(myNode);
			} else {
				// Go back up the stack
				DFS.pop();
			}
		}
	}

	public void readInput() throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(pathToTextFile + "input.txt"));
		String txtFieldLine = input.readLine();
		while (txtFieldLine != null) {
			for (int i = 0; i < 5; i++) {
				String[] num = txtFieldLine.split(",");
				adjacencyMatrix[i][0] = Integer.parseInt(num[0]);
				adjacencyMatrix[i][1] = Integer.parseInt(num[1]);
				adjacencyMatrix[i][2] = Integer.parseInt(num[2]);
				adjacencyMatrix[i][3] = Integer.parseInt(num[3]);
				adjacencyMatrix[i][4] = Integer.parseInt(num[4]);
				txtFieldLine = input.readLine();
			}
		}
		input.close();
	}

	public int getChild(int i) {
		for (int j = 0; j < 5; j++) {
			if (adjacencyMatrix[i][j] == 1 && !visited[j]) {
				return j;
			}
		}
		return -1;
	}

}
