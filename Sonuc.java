/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

import java.util.Set;

/**
 *
 * @author Polat
 */
public class Sonuc {
    private Node current;
    private Set<String[]> set;
    private Node root;

    /**
     * @return the current
     */
    public Node getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Node current) {
        this.current = current;
    }

    /**
     * @return the set
     */
    public Set<String[]> getSet() {
        return set;
    }

    /**
     * @param set the set to set
     */
    public void setSet(Set<String[]> set) {
        this.set = set;
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node root) {
        this.root = root;
    }
    public Sonuc(Node current,Set<String[]> set,Node root){
        this.current=current;
        this.set=set;
        this.root=root;
    }
    
}
