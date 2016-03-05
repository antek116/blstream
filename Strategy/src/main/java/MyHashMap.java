/**
 *
 * Created by user on 04.03.2016.
 */
public class MyHashMap<KeyType,ValueType> extends HashMap {

    MyHashMap(){};

    /**
     * Method returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key
     */
    @Override
    public ValueType get(Object key) {
            ElementClass element = findElement(key);
            if(element != null) {
                return (ValueType) element.getValue();
            }
            return null;
    }
}
