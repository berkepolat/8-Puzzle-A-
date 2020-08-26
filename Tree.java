/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg8puzzle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Polat
 */
public class Tree {

    private Node kok;
    private String[] hedef;

    /**
     * @return the kok
     */
    public Node getKok() {
        return kok;
    }

    /**
     * @param kok the kok to set
     */
    public void setKok(Node kok) {
        this.kok = kok;
    }

    /**
     * @return the hedef
     */
    public String[] getHedef() {
        return hedef;
    }

    /**
     * @param hedef the hedef to set
     */
    public void setHedef(String[] hedef) {
        this.hedef = hedef;
    }

    public Tree(Node kok, String[] hedef) {
        this.kok = kok;
        this.hedef = hedef;
    }

    public String toStr(String[] str) {
        List<String> list = Arrays.asList(str);
        String delim = "";
        String res = String.join(delim, list);
        return res;
    }

    public List<String> hareket(String[] durum) {
        List<String> dallar = new ArrayList<String>();
        String[] durum1, durum2, durum3, durum4, temp;
        durum1 = durum.clone();
        durum2 = durum.clone();
        durum3 = durum.clone();
        durum4 = durum.clone();
        temp = durum.clone();
        switch ((Arrays.asList(durum)).indexOf("0")) {
            case 0:
                durum1[1] = temp[0];
                durum1[0] = temp[1];
                temp=durum.clone();
                durum2[0] = temp[3];
                durum2[3] = temp[0];
                dallar.add(toStr(durum1));
                dallar.add(toStr(durum2));
                break;
            case 1:
                durum1[0] = temp[1];
                durum1[1] = temp[0];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[2] = temp[1];
                durum2[1] = temp[2];
                dallar.add(toStr(durum2));
                temp=durum.clone();
                durum3[4] = temp[1];
                durum3[1] = temp[4];
                dallar.add(toStr(durum3));
                break;
            case 2:
                durum1[1] = temp[2];
                durum1[2] = temp[1];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[2] = temp[5];
                durum2[5] = temp[2];
                dallar.add(toStr(durum2));
                break;
            case 3:
                durum1[3] = temp[0];
                durum1[0] = temp[3];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[3] = temp[4];
                durum2[4] = temp[3];
                dallar.add(toStr(durum2));
                temp=durum.clone();
                durum3[3] = temp[6];
                durum3[6] = temp[3];
                dallar.add(toStr(durum3));
                break;
            case 4:
                durum1[4] = temp[1];
                durum1[1] = temp[4];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[4] = temp[3];
                durum2[3] = temp[4];
                dallar.add(toStr(durum2));
                temp=durum.clone();
                durum3[4] = temp[5];
                durum3[5] = temp[4];
                dallar.add(toStr(durum3));
                temp=durum.clone();
                durum4[4] = temp[7];
                durum4[7] = temp[4];
                dallar.add(toStr(durum4));
                break;
            case 5:
                durum1[5] = temp[2];
                durum1[2] = temp[5];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[5] = temp[4];
                durum2[4] = temp[5];
                dallar.add(toStr(durum2));
                temp=durum.clone();
                durum3[5] = temp[8];
                durum3[8] = temp[5];
                dallar.add(toStr(durum3));
                break;
            case 6:
                durum1[6] = temp[3];
                durum1[3] = temp[6];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[6] = temp[7];
                durum2[7] = temp[6];
                dallar.add(toStr(durum2));
                break;
            case 7:
                durum1[7] = temp[4];
                durum1[4] = temp[7];
                dallar.add(toStr(durum1));
                temp=durum.clone();
                durum2[7] = temp[6];
                durum2[6] = temp[7];
                dallar.add(toStr(durum2));
                temp=durum.clone();
                durum3[7] = temp[8];
                durum3[8] = temp[7];
                dallar.add(toStr(durum3));
                break;
            case 8:
                durum1[8] = temp[5];
                durum1[5] = temp[8];
                temp=durum.clone();
                durum2[8] = temp[7];
                durum2[7] = temp[8];
                dallar.add(toStr(durum1));
                dallar.add(toStr(durum2));
                break;
        }

        return dallar;
    }
    public Sonuc aStarSolve() throws NullPointerException{
        Set<String> durumlar = new HashSet<String>();
        Node n = new Node(kok.getDurum());
        int totalCost=0;
        n.setTotCost(0);
        NodePriorityComparator cmp = new NodePriorityComparator();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(10, cmp);
        Node curr = n;
        try{
        while (!(Arrays.equals(curr.getDurum(), hedef)))  {
            durumlar.add(toStr(curr.getDurum()));
            List<String> dalListe = hareket(curr.getDurum());
           
            for (String s : dalListe) {
                if (durumlar.contains(s))
                    continue;
                
                durumlar.add(s);
                Node ch = new Node(s.split(""));
                curr.addChild(ch);
                ch.setParent(curr);
                ch.setTotCost(curr.getTotCost() + Character.getNumericValue(toStr(ch.getDurum()).charAt(toStr(ch.getParent().getDurum()).indexOf('0'))), manhattan(toStr(ch.getDurum()), toStr(hedef)));
                pq.add(ch);
                
            }
            curr = pq.poll();
        }
        }
        catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Bu problem çözümlü değil. Yeni random problem alın.(Aslında random alırken çözümlü olup olmadığına bakıyor"
                        + " ama neden böyle oldu anlamadım. Özür dilerim.)", "A* 8-Puzzle", JOptionPane.INFORMATION_MESSAGE);
                }
         Set<String[]> durumlar2 = new HashSet<>();
        for(String s : durumlar){
            durumlar2.add(s.split(""));
        }
        return new Sonuc(curr,durumlar2,kok);
    }

    private int manhattan(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }
}
