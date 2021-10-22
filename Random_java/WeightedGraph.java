package com.cdw.dsapart2;

import javax.print.attribute.standard.PresentationDirection;
import java.util.*;

public class WeightedGraph {
    Map<String, wgnode> nodes = new HashMap<>();
    class wgnode
    {
        String label;
        wgnode(String label){
            this.label = label;
        }
        private List<edge> edges = new ArrayList<>();
        public void addEdge(wgnode to,int weight)
        {
            edges.add(new edge(this,to,weight));
        }
        @Override
        public String toString()
        {
            return label;
        }
        public List<edge> getEdges()
        {
            return edges;
        }
    }
    class edge
    {
        wgnode from;
        wgnode to;
        int weight;
        public edge(wgnode f,wgnode t,int w)
        {
            from = f;
            to = t;
            weight = w;
        }
        @Override
        public String toString()
        {
            return from +"->"+to;
        }
    }
    void addNode(String label)
    {
        nodes.putIfAbsent(label,new wgnode(label));
    }
    void addEdge(String from, String to,int value)
    {
        var fromNode = nodes.get(from);
        if(fromNode == null)
        {
            throw new IllegalArgumentException();
        }
        var toNode = nodes.get(to);
        if(toNode==null)
            throw new IllegalArgumentException();
        fromNode.addEdge(toNode,value);
        toNode.addEdge(fromNode, value);
    }
    void print() {
        for(var node: nodes.values())
        {
            var targets = node.getEdges();
            if(!targets.isEmpty())
                System.out.println(node + " is connected to " + targets);
        }
    }
    class NodeEntry
    {
        wgnode node;
        int priority;
        NodeEntry(wgnode node,int priority) {
            this.node = node;
            this.priority=priority;
        }
    }
    Path getShortestPath(String from, String to)
    {
        Map<wgnode,Integer> distances =  new HashMap<>();
        for(var node : nodes.values())
        {
            distances.put(node, Integer.MAX_VALUE);
        }
        var fromnode = (nodes.get(from));
        distances.replace(fromnode,0);
        Map<wgnode,wgnode> previousNodes = new HashMap<>();
        Set<wgnode> visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromnode,0));
        while(!queue.isEmpty()){
            wgnode current = queue.remove().node;
            visited.add(current);
            for(var edge : current.getEdges()){
                if(visited.contains((edge.to)))
                {
                    continue;
                }
                var newD=distances.get(current)+edge.weight;
                if(newD < distances.get(edge.to)) {

                    distances.replace(edge.to, newD);
                    previousNodes.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to,newD));

                }
            }
        }
        wgnode toNode = nodes.get(to);
        return buildPath(previousNodes,toNode);
    }
    public boolean hasCycle()
    {
        Set<wgnode> visited = new HashSet<>();
        for(var node: nodes.values())
        {
            if(!visited.contains(node)&&hasCycle(node,null,visited))
            {
                return true;
            }
        }
        return false;
    }
    boolean hasCycle(wgnode node, wgnode parent, Set<wgnode> visited)
    {
        visited.add(node);
        for(var edge : node.getEdges())
        {
            if(edge.to==parent)
                continue;
            if(visited.contains(edge.to)||hasCycle(edge.to,node,visited))
                return true;
        }
        return false;
    }
    private Path buildPath(Map<wgnode,wgnode> previousNodes,wgnode toNode)
    {
        Stack<wgnode> stack = new Stack<>();

        stack.push(toNode);
        var previous = previousNodes.get(toNode);
        while(previous!=null)
        {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }
        var path = new Path();
        while(!stack.isEmpty())
            path.add(stack.pop().label);
        return path;
    }
    public WeightedGraph minimumspanningtree()
    {
        var tree = new WeightedGraph();
        PriorityQueue<edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        wgnode start = nodes.values().iterator().next();
        edges.addAll(start.getEdges());
        tree.addNode(start.label);
        while(tree.nodes.size()<nodes.size())
        {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if(tree.nodes.containsKey(minEdge.to.label))
            {
                continue;
            }
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label,nextNode.label,minEdge.weight);

            for(var edge : nextNode.getEdges())
            {
                if(!tree.containsNode(edge.to.label))
                {
                    edges.add(edge);
                }
            }

        }
        return tree;
    }
    public boolean containsNode(String label)
    {
        return nodes.containsKey(label);
    }
}
