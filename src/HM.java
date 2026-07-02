	import java.util.*;

	public class HM {

	    static class DynamicArray<T> {
	        private T[] array;
	        private int size;
	        private int capacity;

	        public DynamicArray() {
	            capacity = 10;
	            array = (T[]) new Object[capacity];
	            size = 0;
	        }

	        public void add(T element) {
	            if (size == capacity) resize();
	            array[size++] = element;
	        }

	        public void remove(int index) {
	            if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
	            for (int i = index; i < size - 1; i++) {
	                array[i] = array[i + 1];
	            }
	            array[--size] = null;
	        }

	        public T get(int index) {
	            if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index");
	            return array[index];
	        }

	        private void resize() {
	            capacity *= 2;
	            array = Arrays.copyOf(array, capacity);
	        }

	        public void printArray() {
	            if (size == 0) {
	                System.out.println("Array is empty.");
	                return;
	            }
	            for (int i = 0; i < size; i++) {
	                System.out.print(array[i] + " ");
	            }
	            System.out.println();
	        }
	    }

	    static class SinglyLinkedList<T> {
	        private class Node {
	            T data;
	            Node next;

	            Node(T data) {
	                this.data = data;
	                this.next = null;
	            }
	        }

	        private Node head;

	        public void insert(T data) {
	            Node newNode = new Node(data);
	            if (head == null) {
	                head = newNode;
	            } else {
	                Node temp = head;
	                while (temp.next != null) temp = temp.next;
	                temp.next = newNode;
	            }
	        }

	        public void delete(T data) {
	            if (head == null) return;

	            if (head.data.equals(data)) {
	                head = head.next;
	                return;
	            }

	            Node temp = head;
	            while (temp.next != null && !temp.next.data.equals(data)) temp = temp.next;

	            if (temp.next != null) temp.next = temp.next.next;
	        }

	        public void traverse() {
	            if (head == null) {
	                System.out.println("List is empty.");
	                return;
	            }
	            Node temp = head;
	            while (temp != null) {
	                System.out.print(temp.data + " ");
	                temp = temp.next;
	            }
	            System.out.println();
	        }
	    }

	    static class DoublyLinkedList<T> {
	        private class Node {
	            T data;
	            Node prev, next;

	            Node(T data) {
	                this.data = data;
	                this.prev = this.next = null;
	            }
	        }

	        private Node head;

	        public void insert(T data) {
	            Node newNode = new Node(data);
	            if (head == null) {
	                head = newNode;
	            } else {
	                Node temp = head;
	                while (temp.next != null) temp = temp.next;
	                temp.next = newNode;
	                newNode.prev = temp;
	            }
	        }

	        public void delete(T data) {
	            if (head == null) return;

	            if (head.data.equals(data)) {
	                head = head.next;
	                if (head != null) head.prev = null;
	                return;
	            }

	            Node temp = head;
	            while (temp != null && !temp.data.equals(data)) temp = temp.next;

	            if (temp != null) {
	                if (temp.next != null) temp.next.prev = temp.prev;
	                if (temp.prev != null) temp.prev.next = temp.next;
	            }
	        }

	        public void traverse() {
	            if (head == null) {
	                System.out.println("List is empty.");
	                return;
	            }
	            Node temp = head;
	            while (temp != null) {
	                System.out.print(temp.data + " ");
	                temp = temp.next;
	            }
	            System.out.println();
	        }
	    }

	    static class CircularLinkedList<T> {
	        private class Node {
	            T data;
	            Node next;

	            Node(T data) {
	                this.data = data;
	                this.next = null;
	            }
	        }

	        private Node head;

	        public void insert(T data) {
	            Node newNode = new Node(data);
	            if (head == null) {
	                head = newNode;
	                head.next = head;
	            } else {
	                Node temp = head;
	                while (temp.next != head) temp = temp.next;
	                temp.next = newNode;
	                newNode.next = head;
	            }
	        }

	        public void delete(T data) {
	            if (head == null) return;

	            if (head.data.equals(data)) {
	                if (head.next == head) {
	                    head = null;
	                    return;
	                }
	                Node temp = head;
	                while (temp.next != head) temp = temp.next;
	                temp.next = head.next;
	                head = head.next;
	                return;
	            }

	            Node current = head;
	            while (current.next != head && !current.next.data.equals(data)) {
	                current = current.next;
	            }

	            if (current.next != head) {
	                current.next = current.next.next;
	            }
	        }

	        public void traverse(int limit) {
	            if (head == null) {
	                System.out.println("List is empty.");
	                return;
	            }
	            Node temp = head;
	            int count = 0;
	            do {
	                System.out.print(temp.data + " ");
	                temp = temp.next;
	                count++;
	            } while (temp != head && count < limit);
	            System.out.println();
	        }
	    }

	    static class Graph {
	        private Map<String, List<String>> adjacencyList;

	        public Graph() {
	            adjacencyList = new HashMap<>();
	        }

	        public void addEdge(String task1, String task2) {
	            adjacencyList.putIfAbsent(task1, new ArrayList<>());
	            adjacencyList.get(task1).add(task2);
	        }

	        public void printGraph() {
	            for (String task : adjacencyList.keySet()) {
	                System.out.print(task + " -> ");
	                for (String neighbor : adjacencyList.get(task)) {
	                    System.out.print(neighbor + " ");
	                }
	                System.out.println();
	            }
	        }

	        public void bfs(String start) {
	            Set<String> visited = new HashSet<>();
	            Queue<String> queue = new LinkedList<>();
	            queue.add(start);
	            visited.add(start);
	            while (!queue.isEmpty()) {
	                String task = queue.poll();
	                System.out.print(task + " ");
	                for (String neighbor : adjacencyList.getOrDefault(task, new ArrayList<>())) {
	                    if (!visited.contains(neighbor)) {
	                        visited.add(neighbor);
	                        queue.add(neighbor);
	                    }
	                }
	            }
	            System.out.println();
	        }
	    }
	    
	    static class Stack<T> {
	        private LinkedList<T> stack;

	        public Stack() {
	            stack = new LinkedList<>();
	        }

	        public void push(T item) {
	            stack.addFirst(item);
	        }

	        public T pop() {
	            if (isEmpty()) throw new EmptyStackException();
	            return stack.removeFirst();
	        }

	        public T peek() {
	            if (isEmpty()) throw new EmptyStackException();
	            return stack.getFirst();
	        }

	        public boolean isEmpty() {
	            return stack.isEmpty();
	        }
	    }

	    static class CustomPriorityQueue<T extends Comparable<T>> {
	        private java.util.PriorityQueue<T> priorityQueue;

	        public CustomPriorityQueue() {
	            priorityQueue = new java.util.PriorityQueue<>();
	        }

	        public void add(T item) {
	            priorityQueue.add(item);
	        }

	        public T poll() {
	            return priorityQueue.poll();
	        }

	        public T peek() {
	            return priorityQueue.peek();
	        }

	        public boolean isEmpty() {
	            return priorityQueue.isEmpty();
	        }
	    }

	    static class BinarySearchTree {
	        private class Node {
	            String task;
	            Date dueDate;
	            Node left, right;

	            public Node(String task, Date dueDate) {
	                this.task = task;
	                this.dueDate = dueDate;
	            }
	        }

	        private Node root;

	        public void insert(String task, Date dueDate) {
	            root = insertRec(root, task, dueDate);
	        }

	        private Node insertRec(Node root, String task, Date dueDate) {
	            if (root == null) {
	                root = new Node(task, dueDate);
	                return root;
	            }

	            if (dueDate.before(root.dueDate)) {
	                root.left = insertRec(root.left, task, dueDate);
	            } else if (dueDate.after(root.dueDate)) {
	                root.right = insertRec(root.right, task, dueDate);
	            }

	            return root;
	        }

	        public void inOrderTraversal() {
	            inOrderTraversalRec(root);
	        }

	        private void inOrderTraversalRec(Node root) {
	            if (root != null) {
	                inOrderTraversalRec(root.left);
	                System.out.println(root.task + " due on: " + root.dueDate);
	                inOrderTraversalRec(root.right);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
	        // Example of testing all data structures
	        System.out.println("Testing DynamicArray:");
	        DynamicArray<String> dynamicArray = new DynamicArray<>();
	        dynamicArray.add("Work");
	        dynamicArray.add("Personal");
	        dynamicArray.add("Urgent");
	        dynamicArray.printArray();

	        System.out.println("\nTesting SinglyLinkedList:");
	        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
	        singlyLinkedList.insert("Task1");
	        singlyLinkedList.insert("Task2");
	        singlyLinkedList.traverse();
	        singlyLinkedList.delete("Task1");
	        singlyLinkedList.traverse();

	        System.out.println("\nTesting DoublyLinkedList:");
	        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
	        doublyLinkedList.insert("TaskA");
	        doublyLinkedList.insert("TaskB");
	        doublyLinkedList.traverse();
	        doublyLinkedList.delete("TaskA");
	        doublyLinkedList.traverse();

	        System.out.println("\nTesting CircularLinkedList:");
	        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();
	        circularLinkedList.insert("RecurringTask1");
	        circularLinkedList.insert("RecurringTask2");
	        circularLinkedList.traverse(5);
	        circularLinkedList.delete("RecurringTask1");
	        circularLinkedList.traverse(5);

	        System.out.println("\nTesting Graph:");
	        Graph graph = new Graph();
	        graph.addEdge("Task1", "Task2");
	        graph.addEdge("Task2", "Task3");
	        graph.printGraph();
	        graph.bfs("Task1");
	        
	        CustomPriorityQueue<String> priorityQueue = new CustomPriorityQueue<>();
	        priorityQueue.add("Urgent Task");
	        priorityQueue.add("Important Task");
	        System.out.println("Top priority: " + priorityQueue.peek());

	        // Stack testing
	        Stack<String> undoStack = new Stack<>();
	        undoStack.push("Task Added");
	        System.out.println("Undo Action: " + undoStack.pop());

	        // BinarySearchTree testing
	        BinarySearchTree taskTree = new BinarySearchTree();
	        taskTree.insert("Project A", new Date(2024, 12, 15));
	        taskTree.insert("Project B", new Date(2024, 12, 10));
	        System.out.println("Tasks sorted by due date:");
	        taskTree.inOrderTraversal();
	    }
	}
