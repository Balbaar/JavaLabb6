package test.bst;

import main.bst.BinarySearchTree;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
	private BinarySearchTree<Integer> tree;

	@AfterEach
	void tearDown() {
		tree = null;
	}

	@Nested
	@DisplayName("an empty tree")
	class Zero {

		@BeforeEach
		void setUp() {
			tree = new BinarySearchTree<Integer>();
		}

		@Test
		@DisplayName("has a size of 0")
		public void size() {
			assertEquals(0, tree.size(), "Wrong size of empty tree");
		}



		@Test
		@DisplayName("can add one element.")
		public void canAddOneElement() {
			assertTrue(tree.add(500));
		}

		@Test
		@DisplayName("has a height of -1")
		public void height() {
			assertEquals(-1, tree.height(), "Wrong height of empty tree");
		}

		@Test
		@DisplayName("is represented by an empty array")
		void toArrayCanReturnAnEmptyArray(){
			assertEquals(new ArrayList<>(), tree.toArray());
		}

		@Test
		@DisplayName("is represented by empty string")
		public void canBeAString()
		{
			assertEquals("", tree.toString());
		}

		@Test
		@DisplayName("is empty also when traversed pre-order")
		void traversePreOrder(){
			assertEquals(new ArrayList<>(), tree.preOrdered());
		}
	}


	@Nested
	@DisplayName("a tree with one element")
	class One {

		@BeforeEach
		void setUp() {
			tree = new BinarySearchTree<Integer>();
			tree.add(500);
		}

		@Test
		@DisplayName("has a size of 1.")
		void size() {
			assertEquals(1, tree.size(), "Wrong size of empty tree");
		}

		@Test
		@DisplayName("has a size of 2 when another element is added.")
		void addOneChangesSize() {
			tree.add(100);
			assertEquals(2, tree.size(), "Wrong size after clear");
		}

		@Test
		@DisplayName("has a height of 0.")
		void height() {
			assertEquals(0, tree.height(), "Wrong height of empty tree");
		}

		@Test
		@DisplayName("is empty when cleared.")
		void clear() {
			tree.clear();
			assertEquals(0, tree.size(), "Wrong size after clear");
		}

		@Test
		@DisplayName("is represented of an array of that element.")
		void arrayFromOneNode(){
			List expected = List.of(500);
			assertEquals(expected, tree.toArray() );
		}

		@Test
		@DisplayName("can be represented by a string.")
		void canBeAString(){
			assertEquals("500", tree.toString());
		}

		@Test
		@DisplayName("has one element also when traversed pre-order.")
		void traversePreOrder(){
			assertIterableEquals(List.of(500), tree.preOrdered());
		}
	}

	@Nested
	@DisplayName("a tree with many elements")
	class Many {

		@BeforeEach
		void setUp() {
			tree = new BinarySearchTree<Integer>();
			int [] values = {500, 200, 300, 400, 100, 700, 600, 800, 1000, 900};
			for (int value:values){
				tree.add(value);
			}
		}

		@Test
		@DisplayName("has the correct size.")
		void size() {
			assertEquals(10, tree.size(), "Wrong size after add");
			}

		@Test
		@DisplayName("do not allow duplicates.")
		void testDuplicates() {
			assertFalse(tree.add(1000));
		}

		@Test
		@DisplayName("does not grow from duplicates.")
		void testSizeDuplicates() {
			tree.add(500);
			assertEquals(10, tree.size());
		}

		@Test
		@DisplayName("allows new unique elements.")
		void canAddOne() {
			assertTrue(tree.add(999));
		}

		@Test
		@DisplayName("has correct height.")
		public void height(){
			assertEquals(4, tree.height(), "Wrong height after add");
		}

		@Test
		@DisplayName("can be cleared.")
		public void clear(){
			tree.clear();
			assertNull(tree.getRoot(), "root should be null");
		}

		@Test
		@DisplayName("has an array with its elements")
		void canReturnAnArray(){
			List expected = List.of( 100, 200, 300, 400, 500 ,600, 700, 800, 900, 1000);
			assertEquals(expected, tree.toArray() );
		}

		@Test
		@DisplayName("can be represented as a string")
		void canBeRepresentedAsAString(){
			assertEquals("100-200-300-400-500-600-700-800-900-1000", tree.toString());
		}

		@Test
		@DisplayName("does not change size when rebuilt.")
		void doesNotChangeSize(){
			tree.rebuild();
			assertEquals(10, tree.size());
		}

		@Test
		@DisplayName("changes height when rebuilt")
		void changesHeightWhenRebuilt(){
			tree.rebuild();
			assertEquals(3, tree.height());
		}

		@Test
		@DisplayName("can be traversed pre-order")
		void traversePreOrder(){
			List<Integer> values = List.of(500, 200, 100, 300, 400, 700, 600, 800, 1000, 900);
			assertEquals(values, tree.preOrdered());
		}
	}

	@Nested
	@DisplayName("a tree that sorts by string length")
	class Comparator {
		private BinarySearchTree<String> tree;

		@BeforeEach
		void setUp() {
			tree = new BinarySearchTree<>((s1, s2) -> s1.length() - s2.length());
			String [] values = {"BB", "CCC", "DDDD", "EEEEE", "A"};
			for (String value:values){
				tree.add(value);
			}
		}

		@Test
		@DisplayName("has the correct size")
		void size(){
			assertEquals(5, tree.size(), "Wrong size after add");
		}

		@Test
		@DisplayName("can not add a string with the same length")
		void canNotAddSameLength() {
			assertFalse(tree.add("1"));
		}

		@Test
		@DisplayName("has the correct height")
		void height(){
			assertEquals(3, tree.height(), "Wrong height after add");
		}

		@Test
		@DisplayName("has an array with its elements")
		void canReturnAnArray(){
			List expected = List.of( "A", "BB", "CCC", "DDDD", "EEEEE");
			assertEquals(expected, tree.toArray() );
		}

		@Test
		@DisplayName("can be represented as a string")
		void canBeRepresentedAsAString(){
			assertEquals("A-BB-CCC-DDDD-EEEEE", tree.toString());
		}

		@Test
		@DisplayName("changes height when rebuilt")
		void changesHeightWhenRebuilt(){
			tree.rebuild();
			assertEquals(2, tree.height());
		}

		@Test
		@DisplayName("does not change size when rebuilt.")
		void doesNotChangeSize(){
			tree.rebuild();
			assertEquals(5, tree.size());
		}

		@Test
		@DisplayName("does not change in-order when rebuilt")
		void doesNotChangeInOrderWhenRebuilt(){
			tree.rebuild();
			assertEquals("A-BB-CCC-DDDD-EEEEE", tree.toString());
		}

		@Test
		@DisplayName("can be traversed pre-order")
		void traversePreOrder(){
			List<String> values = List.of("BB", "A", "CCC", "DDDD", "EEEEE");
			assertEquals(values, tree.preOrdered());
		}

		@Test
		@DisplayName("changes preorder when rebuilt")
		void changesPreorderWhenRebuilt(){
			tree.rebuild();
			List<String> values = List.of("CCC", "A", "BB", "DDDD", "EEEEE");
			assertEquals(values, tree.preOrdered());
		}


		@Nested
		class BadInput {

			@Test
			void causesException(){

				assertThrows( ClassCastException.class, ()->{
					BinarySearchTree<BinarySearchTree> numberTree = new BinarySearchTree<>();
					numberTree.add(new BinarySearchTree());
					numberTree.add(new BinarySearchTree());
				});
			}

		}
	}
}
