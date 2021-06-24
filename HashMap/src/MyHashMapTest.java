import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyHashMapTest {

	@Test
	public void MyHashMap_Size() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(0, map.size(), 0.00001);
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(2, map.size(), 0.00001);
	}
	
	@Test
	public void MyHashMap_Empty() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(true, map.isEmpty());
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(false, map.isEmpty());
	}
}
