/*
 * API: put(K key, V value): V 
 * get(K Key): V
 * isEmpty(): boolean
 * size(): int
 * containsKey(K key): boolean
 * containsValue(V value)£º boolean
 * fields:
 * 1.array of entry:Entry[]
 * 2.load factor:float
 * 3.size: int
 * step 1: create an entry class
 * step 2: create an array of entry
 * step 3: convert key to hash code
 * step 4: convert has code to responding index in the array
 */
public class MyHashMap<K, V> {
	static class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
	}
	
	private Entry<K, V>[] array;
	private int size;
	private float load_factor;
	
	public static final int DEFAULT_SIZE = 16;
	public static final float LOAD_FACTOR = 0.75f;
	
	public MyHashMap(int capacity, float load_factor) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("capacity can't be 0");
		}
		array = (Entry<K, V>[])new Entry[capacity];
		this.load_factor = load_factor;
	}
	
	public MyHashMap() {
		this(DEFAULT_SIZE, LOAD_FACTOR);
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private int hash(K key) {
		return key == null ? 0 : key.hashCode() & 0x7FFFFFFF;
	}
	
	private int getIndex(K key) {
		return hash(key) % array.length;
	}
	
	private boolean equalsKey(K k1, K k2) {
		if (k1 == null && k2 == null) {
			return true;
		}
		if (k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		while (head != null) {
			if (equalsKey(key, head.key)) {
				return true;
			}
			head = head.next;
		} // head == null
		return false;
	}
	
	private boolean equalsValue(V v1, V v2) {
		if (v1 == null && v2 == null) {
			return true;
		}
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}
	
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		for (Entry<K, V> entry : array) {
			while (entry != null) {
				if (equalsValue(value, entry.value)) {
					return true;
				}
				entry = entry.next;
			}
		}
		return false;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		while (head != null) {
			if (equalsKey(key, head.key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public V put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> head = array[index];
		Entry<K, V> cur = head;
		while (cur != null) {
			if (equalsKey(key, cur.key)) {
				V ori = cur.value;
				cur.value = value;
				return ori;
			}
			cur = cur.next;
		}
		Entry<K, V> newEntry = new Entry(key, value);
		newEntry.next = head;
		array[index] = newEntry;
		size++;
		if (needRehashing()) {
			rehash();
		}
		return null;
	}
	
	private boolean needRehashing() {
		float ratio = (size + 0.0f) / array.length;
		return ratio >= load_factor;
	}
	
	private void rehash() {
		Entry<K, V>[] oldArray = array;
		array = (Entry<K, V>[])new Entry[oldArray.length * 2];
		for (Entry<K, V> entry : oldArray) {
			int index = getIndex(entry.getKey());
			Entry<K, V> head = array[index];
			entry.next = head;
			array[index] = entry;
		}
	}
}
