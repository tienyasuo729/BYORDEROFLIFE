/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pecsd1;

/**
 *
 * @author Linh
 */

//I. For binary search tree class, write the following functions:
// Each node in T contains four fields of: 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//(a) data: teacher’s information (included code: int, coeff: double), 
//(b) left: the link to the left sub-tree, 
//(c) right: the link to the right sub-tree, and 
//(d) bal: the differences in heights of left sub-tree and right sub-tree.
//1. To obtain the tree from A.
//2. Increase M/2.0 to the coeff of each teacher where M is the
//maximum coeff.
//3.  Print all nodes in the form of <data, level>.
//4.  Determine the field bal for all node.
//5.  Output all teachers in pre-order traversal (recursion).
//II.  Write the function tree_sort() to sort an array of teachers in
//decreasing order of code (Avoid using recursion and java built-in classes! Using bubble sort!). 
//III. A main function to test all requirements.
class teacher implements Comparable<teacher>{
    int code; 
    double coeff;
    public teacher(int code, double coeff) {
        this.code = code;
        this.coeff = coeff;
    }
    @Override public String toString() {
        return "("+code + "," + coeff+")";    
    }
    @Override public int compareTo(teacher o) {
        if (code < o.code) return -1;
        if (code > o.code) return +1;
        return 0;
    }
}
class node implements Comparable<node>{
    teacher data;
    node left, right;
    int bal;
    int level;
    public node(teacher data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.bal = 0; 
        this.level = -1;
    }
    @Override public String toString() {
        return "["+data+":"+level+","+bal+"]";
    }
    @Override public int compareTo(node o) {
        return data.compareTo(o.data);
    }
}
class BST {
    node root;
    public BST() {
        root = null;
    }
    void insert(teacher o) {
        node[] res = search(o);
        if (res[0] != null) return;
        node n = new node(o);
        if (res[1] == null) root=n;
        else if (n.compareTo(res[1]) < 0)
            res[1].left = n;
        else
            res[1].right = n;
    }
    node[] search(teacher o) {
        node t = root, parent = null;
        while (t != null && t.data.compareTo(o) != 0) {
            parent = t;
            if (t.data.compareTo(o) < 0) t= t.right;
            else t=t.left;
        }
        return new node[]{t, parent};
    }
//    [1.0 m] Output all teachers in pre-order traversal (recursion).
    void pre_order() { 
        pre_order(root); 
    }
    void pre_order(node t) { 
        if (t == null) return;
        System.out.println(""+t);
        pre_order(t.left);
        pre_order(t.right); 
    }
//  2.  Print all nodes in the form of <data, level>.
    void level_order() {
        Queue<node> q = new LinkedList<>();
        q.add(root); root.level = 0;
        while (!q.isEmpty()) {
            node t = q.poll(); System.out.println(""+t);
            if (t.left != null) {
                q.add(t.left); t.left.level = t.level + 1;
            }
            if (t.right != null) {
                q.add(t.right); t.right.level = t.level + 1;
            }
        }
    }
//    [1.0 m] Determine the field bal for all node.
    void determine_bal() {
        determine_bal(root);
    }
    int determine_bal(node t) { 
        if (t == null) return 0;
        int hLeft = determine_bal(t.left);
        int hRight = determine_bal(t.right);
        t.bal = hLeft - hRight;
        return 1 + Math.max(hLeft, hRight);
    }
//    int height(node t) { 
//        if (t == null) return 0;
//        int max_left = height(t.left);
//        int max_right = height(t.right);
//        return 1 + Math.max(max_left, max_right);
//    }
//    [1.0 m] Increase M / 2.0 to the coeff of each teacher where M is the maximum coeff.
    void increase() {
        double M = max_coeff(root);
        increase(root, M / 2.0);
    }
    void increase(node t, double delta) { 
        if (t == null) return;
        t.data.coeff += delta;
        increase(t.left, delta);
        increase(t.right, delta); 
    }
    double max_coeff(node t) { 
        if (t == null) return Integer.MIN_VALUE;
        double max_left = max_coeff(t.left);
        double max_right = max_coeff(t.right);
        return Math.max(t.data.coeff, Math.max(max_left, max_right));
    }
    ArrayList<teacher> in_order() { 
        ArrayList<teacher> res = new ArrayList<>();
        in_order(root, res); 
        return res;
    }
    void in_order(node t, ArrayList<teacher> res) { 
        if (t == null) return;
        in_order(t.right, res);
        res.add(t.data);
        in_order(t.left, res); 
    }
    void level_recursion() {
         level_recursion(root, 0); 
    }
    void level_recursion(node t, int level) { 
        if (t == null) return;
        System.out.println(""+ t + " = " + level);
        level_recursion(t.left, level+1);
        level_recursion(t.right, level+1); 
    }
}
public class Main {
    static teacher[] tree_sort(teacher[] A) {
        BST T = new BST();
        for (teacher object : A) {
            T.insert(object);
        }
        return T.in_order().toArray(new teacher[A.length]);
    }
    public static void main(String[] args) {
        teacher[] A = new teacher[]{new teacher(5, 5), new teacher(3, 3), new teacher(2, 2), 
            new teacher(4, 4), new teacher(7, 7), new teacher(6, 6), new teacher(8, 8), 
            new teacher(1, 1), new teacher(9, 9)};
        BST T = new BST();
        for (teacher object : A) {
            T.insert(object);
        }
        System.out.println("Output all teachers in pre-order traversal (recursion)."); 
        T.pre_order(); 
        
        T.increase(); 
        System.out.println("Increase: "); T.level_order(); 
        
        T.determine_bal();
        System.out.println("Bal: "); T.level_order(); 
        
        System.out.println("Sorted: " + Arrays.toString(tree_sort(A)));
        
        T.level_recursion();
    }
    
}