class Main {
  public static void main(String[] args) {
    String[] vertices = {"Liberal Arts", "Student Services", "Health Career & Sciences", "Health and Technologies", 
    "Theatre", "Business & Technology", "Technology Learning Center", "Recreation Center"};

    int[][] edges = {
      {0,1}, {0,7},
      {1,0}, {1,6}, {1,2},
      {2,1}, {2,3}, {2,5},
      {3,1}, {3,4}, {3,4},
      {3,2}, {3,5},
      {4,3}, {4,2}, {4,5},
      {5,4}, {5,1}, {5,6},
      {6,5}, {6,7}, {6,0},
      {7,6},{7,0}
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!

    dfs.printPath(03);

    dfs.printPath(01);
    
    dfs.printPath(07);
    
    dfs.printTree();

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    
    
  }

  
}