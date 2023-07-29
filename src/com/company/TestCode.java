import java.util.*;
import java.io.*;
import java.lang.*;

class TestCode
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V1, ArrayList<ArrayList<Integer>> adj) 
    {
        int V = V1 + 1;
        // add your code here
        System.out.println("Size " + V );
        int[] indegree = new int[V];
        boolean[] visited = new boolean[V];
        // int[V] topoSort = new int[];
        
        List<Integer> topoSort = new ArrayList<>();
        
        indegreeArray(adj, indegree);
        
        System.out.println("indegree array");
        
        for(int i=0; i<V; i++){
            
            System.out.print(indegree[i] + ",");
            
        }
        System.out.println("indegree array");
        
        Queue<Integer> queue = new LinkedList<>();
        
        
        // get the vertex with zero indegree
        for(int i=0; i<V; i++){
     
            if(indegree[i] == 0){
                
                queue.add(i);
                visited[i] = true;
                
            }
            
        }
        
        System.out.println("Starting index with zero as indegree");
        
        System.out.println(queue);
        
        
        while(!queue.isEmpty()){
            
            int u = queue.poll();
            
            for(int v : adj.get(u)){
                
                if(visited[v] == false){
                    visited[v] = true;
                    indegree[v]--;
                    
                    topoSort.add(v);
                    
                    if(indegree[v] == 0) {
                        queue.add(v);
                    }
                }
            }
            
        }
        
        
        int size = topoSort.size();
        int[] ans = new int[size];
        
        for(int i=0; i<size; i++){
            
            ans[i] = topoSort.get(i);
            
        }
        
        return ans;
        
        
    }
    
    
    
    
    static void indegreeArray(ArrayList<ArrayList<Integer>> adj, int[] indegree){
        
        for(ArrayList<Integer> list : adj){
            
            for(int v : list){
                
                indegree[v]++;
                
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjList = 
        Arrays.asList(
            Arrays.asList(1),
             Arrays.asList(2),
              Arrays.asList(3),
               Arrays.asList(4)
        );





        System.out.println("Hi");
        System.out.println(adjList);
    }
}
