package main.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BinarySearchTree<E> {
  private BinaryNode<E> root;
  int size = 0;
  private Comparator<E> comparator;

  public Node<E> getRoot(){
	  return this.root;
  }
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree(){
		this((e1, e2) -> ((Comparable<E>) e1).compareTo(e2));
	}

	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;

	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param e element to be inserted
	 * @return true if the element was inserted
	 */
	public boolean add(E e) {
		if (root == null) {
			root = new BinaryNode<>(e);
			size++;
			return true;
		} else {
			return add(root, e);
		}
	}

	private boolean add(BinaryNode<E> node, E e) {
		int cmp = comparator == null ? ((Comparable<E>) e).compareTo(node.element) : comparator.compare(e, node.element);
		if (cmp < 0) {
			if (node.left == null) {
				node.left = new BinaryNode<>(e);
				size++;
				return true;
			} else {
				return add(node.left, e);
			}
		} else if (cmp > 0) {
			if (node.right == null) {
				node.right = new BinaryNode<>(e);
				size++;
				return true;
			} else {
				return add(node.right, e);
			}
		} else {
			// Element already exists, do not add
			return false;
		}
	}

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}

	private int height(BinaryNode<E> node) {
		if (node == null) {
			return -1;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Removes all the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = toArray();
		root = buildTree(sorted, 0, sorted.size() - 1);
	}

	public ArrayList<E> toArray() {
		ArrayList<E> sorted = new ArrayList<>();
		return toArray(root, sorted);
	}
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private ArrayList<E> toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n != null) {
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
		return sorted;
	}

	@Override
	public String toString() {
		return toArray().stream()
				.map(Object::toString)
				.collect(Collectors.joining("-"));
	}

	/*
	 * Builds a complete tree from the elements from position first to
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first > last) {
			return null;
		}
		int mid = first + (last - first) / 2;
		BinaryNode<E> node = new BinaryNode<>(sorted.get(mid));
		node.left = buildTree(sorted, first, mid - 1);
		node.right = buildTree(sorted, mid + 1, last);
		return node;
	}

    public ArrayList<E>  preOrdered() {
		ArrayList<E> preOrdered = new ArrayList<>();
		return preOrdered(root, preOrdered);
	}

	private ArrayList<E> preOrdered(BinaryNode<E> n, ArrayList<E> preOrdered) {
		if (n != null) {
			preOrdered.add(n.element);
			preOrdered(n.left, preOrdered);
			preOrdered(n.right, preOrdered);
		}
		return preOrdered;
	}

    static class BinaryNode<E> implements Node<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}

		@Override
		public E getValue() {
			return this.element;
		}

		@Override
		public Node<E> getLeft() {
			return this.left;
		}

		@Override
		public Node<E> getRight() {
			return this.right;
		}
	}
	
}
