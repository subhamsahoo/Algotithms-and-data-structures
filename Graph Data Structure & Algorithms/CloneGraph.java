/*

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors

*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
        return null;
        ArrayList<UndirectedGraphNode> allVertices = new ArrayList();
        ArrayList<UndirectedGraphNode> queue = new ArrayList();
        HashSet<UndirectedGraphNode> visitedNodes = new HashSet();
        queue.add(node);
        visitedNodes.add(node);
        while(queue.size()>0)
        {
            UndirectedGraphNode temp=queue.get(0);
            for(int i=0;i<temp.neighbors.size();i++)
            {
                if(visitedNodes.contains(temp.neighbors.get(i)));
                else
                {
                    queue.add(temp.neighbors.get(i));
                    visitedNodes.add(temp.neighbors.get(i));
                }
            }
            allVertices.add(temp);
            queue.remove(0);
        }
        
        //formation of clone
        
        HashMap<UndirectedGraphNode,UndirectedGraphNode> data = new HashMap();
        for(int i=0;i<allVertices.size();i++)
        {
            UndirectedGraphNode temp=new UndirectedGraphNode(allVertices.get(i).label);
            data.put(allVertices.get(i),temp);
        }
        
        for(int i=0;i<allVertices.size();i++)
        {
            UndirectedGraphNode clone = data.get(allVertices.get(i));
            for(int j=0;j<allVertices.get(i).neighbors.size();j++)
            {
                UndirectedGraphNode cloneChild = data.get(allVertices.get(i).neighbors.get(j));
                clone.neighbors.add(cloneChild);
            }
        }
        
        UndirectedGraphNode root=data.get(allVertices.get(0));
        
        
        return root;
    }
}
