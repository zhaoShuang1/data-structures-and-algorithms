package LRU;

public interface LRUCache<K,V> {
	public V get(K key);
	public void put(K key,V value);
	public V remove(K key);
	public int size();
	public int limit();
	public void clear();

}
