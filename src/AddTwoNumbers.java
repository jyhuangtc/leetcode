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
        ListNode dummyHeadNode = new ListNode(0);
        ListNode last = dummyHeadNode;
        while (sum != 0) {
            last.next = new ListNode(sum%10);
            last = last.next;

            sum /= 10;
        }
        return dummyHeadNode.next;
    }

    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    public ListNode addTwoNumbers_3(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0);
        ListNode runner = preHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            runner.next = new ListNode(carry % 10);
            runner = runner.next;
            carry /= 10;
        }
        return preHead.next;
    }

    public ListNode addTwoNumbers_4(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers_5(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2!= null || carry!= 0){
            ListNode tempNode = new ListNode(0);
            int sum = carry;
            if(l1!= null){
                sum = sum + l1.val;
                tempNode = l1; //If l1 exists, make tempNode point to it.
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                tempNode = l2; //If l2 exists, make tempNode point to it.
                l2 = l2.next;
            }
            carry = sum / 10;
            tempNode.val = sum % 10; //Modify tempNode
            curr.next = tempNode;
            curr = curr.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers_6(ListNode l1, ListNode l2) {
        ListNode head = l1 != null ? l1 : l2;
        ListNode tail = head;

        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            tail.val = sum % 10;
            carry = sum / 10;

            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;

            tail.next = l1 != null ? l1 : l2 != null ? l2 : carry != 0 ? new ListNode(carry) : null;
            tail = tail.next;
        }

        return head;
    }

    public ListNode addTwoNumbers_7(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
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
