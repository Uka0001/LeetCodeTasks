package org.example;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }
        return res.next;


//        return Stream.of(l1, l2).reduce((a, b) -> {
//            ListNode dummy = new ListNode();
//            ListNode current = dummy;
//            int carry = 0;
//            while (a != null || b != null) {
//                int sum = carry;
//                if (a != null) {
//                    sum += a.val;
//                    a = a.next;
//                }
//                if (b != null) {
//                    sum += b.val;
//                    b = b.next;
//                }
//                carry = sum / 10;
//                current.next = new ListNode(sum % 10);
//                current = current.next;
//            }
//            if (carry > 0) {
//                current.next = new ListNode(carry);
//            }
//            return dummy.next;
//        }).orElse(null);
    }
}

