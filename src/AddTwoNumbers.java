public class AddTwoNumbers {
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Sum = 0;
        int carry = 1;
        while (l1 != null) {
            l1Sum += l1.val * carry;
            carry *= 10;
            l1 = l1.next;
        }
        int l2Sum = 0;
        carry = 1;
        while (l2 != null) {
            l2Sum += l2.val * carry;
            carry *= 10;
            l2 = l2.next;
        }
        int sum = l1Sum + l2Sum;
        ListNode node = null;
        while (sum != 0) {
            int val = sum%10;
            ListNode childNode = new ListNode(val);

            if (node == null) {
                node = childNode;
            } else {
                ListNode temp = node.next;
                node.next = childNode;
            }
            sum /= 10;
        }
        return node;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode node= addTwoNumbers.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
