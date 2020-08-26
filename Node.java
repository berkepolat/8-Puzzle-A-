/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

import java.util.ArrayList;

/**
 *
 * @author Polat
 */
public class Node {
    private String[] durum;
    private boolean visited;
    private Node parent;
    private ArrayList<Node> children;
    private int cost;
    private int totcost;

    /**
     * @return the state
     */
    public void setTotCost(int totcost){
        this.totcost=totcost;
    }
     public int getTotCost(){
        return totcost;
    }
     public void setTotCost(int totcost,int cost){
        this.totcost=totcost+cost;
    }
    public String[] getDurum() {
        return durum;
    }

    /**
     * @param state the state to set
     */
    public void setDurum(String[] durum) {
        this.durum = durum;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return the children
     */
    public ArrayList<Node> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }
    public Node(String[] durum){
        this.durum=durum;
        children=new ArrayList<Node>();
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
     public void addChild(Node child) {
        children.add(child);
    }
}
