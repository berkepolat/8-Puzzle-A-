/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

import java.util.Comparator;

/**
 *
 * @author Polat
 */
public class NodePriorityComparator implements Comparator<Node> {

    @Override
    public int compare(Node x, Node y) {
        if (x.getTotCost() < y.getTotCost()) {
            return -1;
        }
        if (x.getTotCost() > y.getTotCost()) {
            return 1;
        }
        return 0;
    }
}