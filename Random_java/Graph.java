package com.cdw.dsapart2;

import java.util.*;

public class Graph {
    class Gnode
    {
        String label;
        Gnode(String label){
            this.label = label;
        }
        @Override
        public String toString()
        {
            return label;
        }
    }
    Map<String,Gnode> nodes = new HashMap<>();
    Map<Gnode, List<Gnode>> adjList = new HashMap<>();
    void removeNode(String label)
    {
        var node = nodes.get(label);
        if(node == null)
            return;
        for(var n :  adjList.keySet()){
            adjList.get(n).remove(node);
        }
        adjList.remove(node);
        nodes.remove(node);
    }
    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if(fromNode == null || toNode==null)
            return;
        adjList.get(fromNode).remove(toNode);
    }
    void AddNode(String label)
    {
        Gnode node = new Gnode(label);
        nodes.putIfAbsent(label,node);
        adjList.putIfAbsent(node,new ArrayList<>());
    }
    void addEdge(String from,String to)
    {
        var fromNode = nodes.get(from);
        if(fromNode == null)
        {
            throw new IllegalArgumentException();
        }
        var toNode = nodes.get(to);
        if(toNode==null)
            throw new IllegalArgumentException();
        adjList.get(fromNode).add(toNode);
        //Undirected adjList.get(toNode).add(fromNode);
    }
    void DFS(String root)
    {
        DFS(nodes.get(root), new HashSet<>());
    }
    boolean hasCycle()
    {
        Set<Gnode> all = new HashSet<>();
        all.addAll(nodes.values());
        Set<Gnode> visiting = new HashSet<>();
        Set<Gnode> visited = new HashSet<>();
        while(!all.isEmpty())
        {
           var current = all.iterator().next();
           if(hasCycle(current,all,visiting,visited))
               return true;
        }
        return false;
    }
    boolean hasCycle(Gnode node, Set<Gnode> all, Set<Gnode> visiting, Set<Gnode> visited)
    {
        all.remove(node);
        visiting.add(node);
        for(var neighbour : adjList.get(node))
        {
            if(visited.contains(neighbour))
                continue;
            if(visiting.contains(neighbour))
                return true;
            boolean result = hasCycle(node,all,visiting,visited);
            if(result)
                return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
    List<String> topologicalSort()
    {
        Stack<Gnode> stack = new Stack<>();
        Set<Gnode> visited = new HashSet<>();
        for(var node : nodes.values())
            topologicalSort(node,visited,stack);
        List<String> sorted = new ArrayList<>();
        while(!stack.empty())
        {
            sorted.add(stack.pop().label);
        }
        return sorted;
    }
    void topologicalSort(Gnode node, Set<Gnode> visited,Stack<Gnode> stack)
    {
        if(visited.contains(node))
            return;
        visited.add(node);
        for(var n : adjList.get(node))
            topologicalSort(n,visited,stack);
        stack.push(node);
    }
    void BFS(String root)
    {
        Gnode node = nodes.get(root);
        if(root==null)
            return;
        Set<Gnode> visited = new HashSet<>();
        Queue<Gnode> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            var current = queue.remove();
            if(visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);
            for(var neighbour : adjList.get(current))
                if(!visited.contains(neighbour))
                    queue.add(neighbour);
        }
    }
    void DFSi(String root)
    {
        var node = nodes.get(root);
        if(node==null)
            return;
        Set<Gnode> visited = new HashSet<>();
        Stack<Gnode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty())
        {
            var current = stack.pop();
            if(visited.contains(current))
                continue;
            System.out.println(current);
            visited.add(current);
            for(var neighbour : adjList.get(current))
            {
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }
    void DFS(Gnode root, Set<Gnode> visited)
    {
        System.out.println(root);
        visited.add(root);
        for(var node : adjList.get(root))
        {
            if(!visited.contains(node))
                DFS(node,visited);
        }
    }
    void print() {
        for(var source:adjList.keySet())
        {
            var targets = adjList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

}
