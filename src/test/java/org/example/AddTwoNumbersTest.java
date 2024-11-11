package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    private AddTwoNumbers addTwoNumbers;

    @BeforeEach
    public void setUp() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    void addTwoNumbers_Ok() {
        List<Integer> actual = Stream.iterate(addTwoNumbers.addTwoNumbers(new ListNode(2, 4, 3), new ListNode(5, 6, 4)), Objects::nonNull, node -> node.next)
                .map(node -> node.val)
                .toList();
        List<Integer> actual1 = Stream.iterate(addTwoNumbers.addTwoNumbers(new ListNode(0), new ListNode(0)), Objects::nonNull, node -> node.next)
                .map(node -> node.val)
                .toList();
        List<Integer> actual2 = Stream.iterate(addTwoNumbers.addTwoNumbers(new ListNode(9,9,9,9,9,9,9), new ListNode(9,9,9,9)), Objects::nonNull, node -> node.next)
                .map(node -> node.val)
                .toList();
        assertEquals(List.of(7, 0, 8), actual);
        assertEquals(List.of(0), actual1);
        assertEquals(List.of(8,9,9,9,0,0,0,1), actual2);
    }
}