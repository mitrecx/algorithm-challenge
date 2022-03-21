package cn.mitrecx;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title: 155. Min Stack
 * Difficulty: Easy
 * Self Difficulty: 上
 * kw: 数据结构实现
 *
 * @see ArrayList
 */
public class MinStack {
    private static final int INIT_SIZE = 100;
    private int[] elements; // The array buffer into which the elements of the MinStack are stored.
    private int size; // The size of the MinStack (the number of elements it contains).
    private int min; // 最小值
    private int minCount; // 最小值个数

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        elements = new int[INIT_SIZE];
        min = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    public void push(int x) {
        ensureCapacity();

        elements[size++] = x;
        // 维护最小值
        if (x < min) {
            min = x;
            minCount = 1;
        } else if (x == min) {
            minCount++;
        }
    }

    public void pop() {
        int popNum = elements[--size];
        // 维护最小值
        if (popNum == min && --minCount == 0) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(min, elements[i]);
            }
            minCount = 1;
        }
    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;
    }

    /**
     * 扩容
     */
    private void ensureCapacity() {
        if (size >= elements.length - 1) {
            // 1.5 倍
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }

}
