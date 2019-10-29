package leetcode;

import java.util.*;

class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {   //  DFS
        return helper(node);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node){
        if(node == null)
            return null;

        if(map.containsKey(node))
            return map.get(node);

        UndirectedGraphNode dup = new UndirectedGraphNode(node);

        map.put(node, dup);

        for(UndirectedGraphNode neighbor : node.neighbors){
           UndirectedGraphNode newNode = helper(neighbor);
           dup.neighbors.add(newNode);
        }

        return dup;
    }

    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node){
        if(node == null)
            return node;

        List<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        for(UndirectedGraphNode cur : nodes){
            map.put(cur, new UndirectedGraphNode(cur.label));
        }

        for(UndirectedGraphNode cur : nodes){
            UndirectedGraphNode newNode = map.get(cur);

            for(UndirectedGraphNode neighbor : cur.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    public List<UndirectedGraphNode> getNodes(UndirectedGraphNode node){        //  BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);

        while(!queue.isEmpty());
            UndirectedGraphNode cur = queue.poll();

            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>(set);
    }
}
