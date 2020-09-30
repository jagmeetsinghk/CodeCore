package CodeCore.course_dsa;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class TreeDSA {
    public static void main(String[] args) {
        BTNode head = new BTNode(50);
        head.insert(45);
        head.insert(55);
        head.insert(44);
        head.insert(46);
        head.insert(54);
        head.insert(56);

        StringBuilder sb;

        sb = new StringBuilder();
        head.printInorder(sb);
        System.out.println(sb);

        sb = new StringBuilder();
        head.printPreOrder(sb);
        System.out.println(sb);

        sb = new StringBuilder();
        head.printPostOrder(sb);
        System.out.println(sb);

        head.printLevelOrder();


        System.out.println(BTNode.getSize(head));
        System.out.println(BTNode.getMax(head));
        System.out.println(BTNode.getHeight(head));

        System.out.println("-------------------------Print nodes at k level------------------------");

        BTNode.printAtKLevel(head, 0);
        System.out.println();
        BTNode.printAtKLevel(head, 1);
        System.out.println();
        BTNode.printAtKLevel(head, 2);
        System.out.println("\nLeft view: ");

        System.out.println("-------------------------Print left view of a tree------------------------");

        BTNode.printLeftView(head);
        System.out.println();
        BTNode.printLEftViewIterative(head);
        System.out.println();

        System.out.println("-------------------------Check if tree follows child sum property------------------------");
        BTNode childSumBinaryTree = BTNode.createChildSumBinaryTree();
        childSumBinaryTree.printLevelOrder();
        System.out.println(BTNode.isChildSumBinaryTree(childSumBinaryTree));
        System.out.println(BTNode.isChildSumBinaryTree(head));

        System.out.println("-------------------------Check if tree is height balanced------------------------");
        head.printLevelOrder();
        System.out.println(BTNode.isHeightBalanced(head));

        BTNode unbalancedTree = BTNode.createUnbalancedBinaryTree();
        unbalancedTree.printLevelOrder();
        System.out.println(BTNode.isHeightBalanced(unbalancedTree));

        System.out.println("-------------------------Max width of a tree-----------------------");
        System.out.println(BTNode.getMaxWidth(head));

        System.out.println("-------------------------Max width of a tree-----------------------");
//        BTNode dllHead = BTNode.convertToDOublyLinkedListInOrder(head);

    }


    static class BTNode {
        static Integer maxLevel = 0;
        Integer data;
        private BTNode left, right;

        public BTNode(Integer data) {
            this.data = data;
        }

        public static BTNode createChildSumBinaryTree() {
            BTNode root = new BTNode(20);
            root.left = new BTNode(10);
            root.right = new BTNode(10);
            root.left.left = new BTNode(5);
            root.left.right = new BTNode(5);
            root.right.left = new BTNode(5);
            root.right.right = new BTNode(5);
            return root;
        }

        static void printLeftView(BTNode head) {
            printLeftView(head, 1);
            maxLevel = 0;
        }

        static void printLeftView(BTNode root, Integer level) {
            if (root == null) return;
            if (maxLevel < level) {
                System.out.print(root.data + " ");
                maxLevel = level;
            }
            printLeftView(root.left, level + 1);
            printLeftView(root.right, level + 1);
        }

        public static void printLEftViewIterative(BTNode root) {
            if (root == null) return;
            Queue<BTNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                System.out.print(q.peek().data + " ");
                int count = q.size();
                for (int i = 0; i < count; i++) {
                    BTNode curr = q.poll();
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
            }
        }

        public static boolean isChildSumBinaryTree(BTNode root) {
            if (root == null) return true;
            else {
                Integer left = root.left == null ? 0 : root.left.data,
                        right = root.right == null ? 0 : root.right.data;
                return (root.left == null && root.right == null) || (left + right == root.data)
                        && isChildSumBinaryTree(root.left)
                        && isChildSumBinaryTree(root.right);
            }
        }

        public static boolean isHeightBalanced(BTNode root) {
            return checkHeightBalance(root) != -1;
        }

        private static Integer checkHeightBalance(BTNode root) {
            if (root == null) return 0;
            Integer l = checkHeightBalance(root.left);
            if (l == -1) return -1;
            Integer r = checkHeightBalance(root.right);
            if (r == -1) return -1;
            if (Math.abs(l - r) > 1) return -1;
            return Math.max(l, r) + 1;
        }

        public static BTNode createUnbalancedBinaryTree() {
            BTNode root = new BTNode(50);
            root.insert(40);
            root.insert(35);
            root.insert(45);
            root.insert(60);
            root.insert(70);
            root.insert(80);
            return root;
        }

/*        public static BTNode convertToDOublyLinkedListInOrder(BTNode head) {
            if(head == null) return null;
            Queue<BTNode> q = new LinkedList<>();
            BTNode node = head;
        }*/

        public static Integer getMaxWidth(BTNode root) {
            Queue<BTNode> levels = new LinkedList<>();
            if (root == null) return -1;
            int maxWidth = -1;
            levels.add(root);
            while (!levels.isEmpty()) {
                int count = levels.size();
                if (count > maxWidth) maxWidth = count;
                for (int i = 0; i < count; i++) {
                    BTNode node = levels.poll();
                    if (node.left != null) levels.add(node.left);
                    if (node.right != null) levels.add(node.right);
                }
            }
            return maxWidth;
        }

        public static Integer getSize(BTNode root) {
            if (root == null) return 0;
            else return 1 + getSize(root.left) + getSize(root.right);
        }

        public static Integer getMax(BTNode root) {
            if (root == null) return Integer.MIN_VALUE;
            else return max(root.data, max(getMax(root.left), getMax(root.right)));
        }

        public static Integer getHeight(BTNode root) {
            if (root == null) return 0;
            else return 1 + max(getHeight(root.left), getHeight(root.right));
        }

        public static void printAtKLevel(BTNode root, int k) {
            if (root == null) return;
            if (k == 0) System.out.print(root.data + " ");
            else {
                printAtKLevel(root.left, k - 1);
                printAtKLevel(root.right, k - 1);
            }
        }

        public Integer getData() {
            return data;
        }

        public void insert(Integer data) {
            if (data < this.data) {
                if (left == null) left = new BTNode(data);
                else left.insert(data);
            } else {
                if (right == null) right = new BTNode(data);
                else right.insert(data);
            }
        }

        public boolean contains(Integer data) {
            if (data == this.data) return true;
            else if ((data < this.data) && (left != null)) return left.contains(data);
            else if (data > this.data && right != null) return right.contains(data);
            else return false;
        }

        public void printInorder(StringBuilder sb) {
            if (left != null) left.printInorder(sb);
            sb.append(this.data + " ");
            if (right != null) right.printInorder(sb);
        }

        public void printPreOrder(StringBuilder sb) {
            sb.append(this.data + " ");
            if (left != null) left.printPreOrder(sb);
            if (right != null) right.printPreOrder(sb);
        }

        public void printPostOrder(StringBuilder sb) {
            if (left != null) left.printPostOrder(sb);
            if (right != null) right.printPostOrder(sb);
            sb.append(this.data + " ");
        }

        public BTNode findNode(Integer data) {
            if (data == this.data) return this;
            else if ((data < this.data) && (left != null)) return left.findNode(data);
            else if (data > this.data && right != null) return right.findNode(data);
            else return null;
        }

        public void printLevelOrder() {
            Queue<BTNode> q = new LinkedList<>();
            q.add(this);
            while (!q.isEmpty()) {
                int count = q.size();
                for (int i = 0; i < count; i++) {
                    BTNode curr = q.poll();
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                    System.out.print(curr.data + " ");
                }
                System.out.println();
            }
        }
    }
}