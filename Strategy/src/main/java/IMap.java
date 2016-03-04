/**
 *
 * Created by user on 03.03.2016.
 */
public interface IMap<KeyType,ValueType>{

    public void clear();
    public abstract ValueType get(KeyType key);
    public boolean isEmpty();
    public abstract ElementClass put(KeyType key, ValueType value);
    public int size();
    public abstract boolean remove(KeyType key);


}
