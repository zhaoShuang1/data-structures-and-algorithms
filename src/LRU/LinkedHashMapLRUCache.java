package LRU;

import java.util.LinkedHashMap;

public class LinkedHashMapLRUCache<K,V> implements LRUCache<K, V>{
	private InternalCache<K,V> cache;
	private int limit;
	
	
	private class InternalCache<K,V> extends LinkedHashMap<K, V>{
		private static final long serialVersionUID = 1L;
		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
			return size() > limit;
		}
		public InternalCache() {
			super(16, 0.75F, true);
		}
	}
	
	public LinkedHashMapLRUCache(int limit) {
		super();
		this.cache = new InternalCache<>();
		this.limit = limit;
	}

	@Override
	public V get(K key) {
		return this.cache.get(key);
	}

	@Override
	public void put(K key, V value) {
		this.cache.put(key, value);
	}

	@Override
	public V remove(K key) {
		return this.cache.remove(key );
	}

	@Override
	public int size() {
		return this.cache.size();
	}

	@Override
	public int limit() {
		return this.limit;
	}
	
	@Override
	public String toString() {
		return this.cache.toString();
	}
	
	@Override
	public void clear() {
		this.cache.clear();
	}
	
	public static void main(String[] args) {
		LinkedHashMapLRUCache<String, String> cache = new LinkedHashMapLRUCache<String, String>(5);
		cache.put("a", "a");
		cache.put("b", "b");
		cache.put("c", "c");
		cache.put("d", "d");
		cache.put("e", "e");
		cache.put("f", "f");
		System.out.println(cache.toString());
		String string = cache.get("b");
		System.out.println(cache.toString());
		
	}
	

}
