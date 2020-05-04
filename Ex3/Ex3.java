package semester2;
import java.util.ArrayList;

public class Ex3 {
	//Question 1
	public static Node MinAVL(int h) {
		ArrayList <Node> ls = new ArrayList<>();
		ls.add(new Node(0, null, null));
		ls.add(new Node(1,new Node(0, null , null),null));
		Node count = new Node(0, null, null);
		for (int i = 2; i <= h; i++) {// O(log(n))
			count = new Node(i, ls.get(i-2), ls.get(i-1));
			ls.add(count);
			Node temp = new Node(0, null, null);
			Node temp2 = new Node(0, null, null);
			copy(ls.get(i-1), temp);// O(n)
			ls.set(i-2, temp);
			copy(count, temp2);
			ls.set(i-1,temp2);
		}
		pass(ls.get(h));
		return ls.get(h);
	}
	static int t = 100;
	public static void pass(Node root) {// O(n)
		if(root != null) {
			pass(root.left);
			root.data = t++;
			pass(root.right);
		}
	}
	public static void copy(Node old, Node newer) {// O(n)
		if(old.right != null) {
			newer.right = copeNode(old.right);
			copy(old.right, newer.right);
		}
		if(old.left != null) {
			newer.left = copeNode(old.left);
			copy(old.left, newer.left);
		}
	}
	public static Node copeNode(Node n) { 
		Node ans = new Node(0, n.left, n.right);
		return ans;
	}
}
