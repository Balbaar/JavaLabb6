package main.app;

import main.bst.BinarySearchTree;
import main.view.BSTVisualizer;

import javax.swing.*;

public class BSTApplication {

    public static void main(String args[]){
        SwingUtilities.invokeLater(()->{
            BSTVisualizer viz  = new BSTVisualizer( "Binary tree", 800, 800);
            BinarySearchTree<Integer> tree = new BinarySearchTree<>();

            // Samma värden, men i en ordning så att det ena bli balanserat
            // och det andra obalanserat
            // Används som visualisering i uppgiften om att balansera ett träd.

            int [] unbalanced = {500, 200, 300, 400, 100, 700, 600};
            int [] balanced = {400, 200, 300, 600, 100, 700, 500};

            for (int value:balanced){
                tree.add(value);
            }
            viz.drawTree(tree);

        });
    }

}
