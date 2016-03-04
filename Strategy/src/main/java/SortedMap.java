/**
 *
 *  Created by user on 03.03.2016.
 */
public abstract class SortedMap<KeyType,ValueType> extends HashMap<KeyType,ValueType>
            implements ISortedMap<KeyType,ValueType>{

    @Override
    public ISortedMap sortByKey(Order order) {
        return null;
    }

    @Override
    public ISortedMap sortByValue(Order order) {
        return null;
    }
}