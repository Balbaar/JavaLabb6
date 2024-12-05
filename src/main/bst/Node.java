package main.bst;

public interface Node<E> {
	E getValue();
	Node<E> getLeft();
	Node<E> getRight();
}
