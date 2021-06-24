import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyHashMapTest {

	@Test
	public void MyHashMap_size() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(0, map.size(), 0.00001);
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(2, map.size(), 0.00001);
	}
	
	@Test
	public void MyHashMap_empty() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(true, map.isEmpty());
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(false, map.isEmpty());
	}
	
	@Test
	public void MyHashMap_put() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(null, map.get("a"));
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(1, map.get("a"), 0.00001);
		map.put("a", 2);
		assertEquals(2, map.get("a"), 0.00001);
	}
	
	@Test
	public void MyHashMap_get() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(null, map.get("a"));
		map.put("a", 1);
		map.put("b", 1);
		assertEquals(1, map.get("a"), 0.00001);
		map.put("a", 2);
		assertEquals(2, map.get("a"), 0.00001);
	}
	
	@Test
	public void MyHashMap_containsValue() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(false, map.containsValue(58));
		map.put("abcdf", 58);
		assertEquals(true, map.containsValue(58));
		map.put("abcdf", 238238);
		assertEquals(false, map.containsValue(58));
	}
	
	@Test
	public void MyHashMap_containsKey() {
		MyHashMap<String, Integer> map = new MyHashMap<>();
		assertEquals(false, map.containsKey("sdisjdsidj"));
		map.put("sdisjdsidj", 9807);
		assertEquals(true, map.containsKey("sdisjdsidj"));
	}
}
