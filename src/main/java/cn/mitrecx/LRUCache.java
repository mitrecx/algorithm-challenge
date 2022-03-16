package cn.mitrecx;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 146. LRU Cache
 * Difficulty: Medium
 * Self Difficulty: 上
 * kw: Least Recently Used (LRU) cache, 哈希表, 双向链表
 * <p>
 * LRU Cache, 可以通过 "HashMap + 双向链表" 实现. 使用 双向链表 维护缓存使用的时间(先后顺序)
 */
public class LRUCache {
    private final int capacity;
    private int size;
    private final Map<Integer, DeLinkedNode> cache = new HashMap<>();
    private final DeLinkedNode head;
    private final DeLinkedNode tail;

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DeLinkedNode();
        tail = new DeLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DeLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // LRU
        moveToHead(node);
        return node.val;
    }


    public void put(int key, int value) {
        DeLinkedNode node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToHead(node);
            return;
        }
        DeLinkedNode curr = new DeLinkedNode(key, value);
        addToHead(curr);
        cache.put(key, curr);
        size++;
        if (size > capacity) {
            DeLinkedNode removed = removeTail();
            // LRU
            cache.remove(removed.key);
            size--;
        }
    }


    private void addToHead(DeLinkedNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DeLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private DeLinkedNode removeTail() {
        DeLinkedNode last = tail.prev;
        tail.prev = last.prev;
        last.prev.next = tail;
        last.next = null;
        last.prev = null;
        return last;
    }

    // double ended list
    public static class DeLinkedNode {
        int key;
        int val;
        DeLinkedNode prev;
        DeLinkedNode next;

        public DeLinkedNode() {
        }

        public DeLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
