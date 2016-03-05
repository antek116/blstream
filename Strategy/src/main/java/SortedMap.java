import java.util.Comparator;

/**
 *
 *  Created by user on 03.03.2016.
 *
 */
public class SortedMap<KeyType,ValueType> extends HashMap<KeyType,ValueType>
            implements ISortedMap{

    static class MyComparator <T extends Comparable<T>> implements Comparator<T>
    {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }
    class NaturalComparator<T extends Comparable<T>> implements Comparator<T>{
        public int compare(T a, T b) {
            return a.compareTo(b);
        }
    }

    @Override
    public ISortedMap sortByKey(Comparator comparator) {
        for(int i=0;i<size();) {
            comparator.compare((Comparable) table[i].getValue(),(Comparable) table[i+1].getValue());
        }
        return null;
    }


    @Override
    public ISortedMap sortByValue(Order order) {
        return null;
    }

    @Override
    public ValueType get(KeyType key) {
        int i = 0;
        if(table[0] == null){
            return null;}
        ElementClass tmpElement = table[0];
        while(i < table.length)
        {
            if(table[i] != null && table[i].getNextElement() == null && table[i].getKey()== key){
                return (ValueType) table[i].getValue();
            }
            if( table[i] != null && table[i].getNextElement() != null && table[i].getKey() != key ){
                return findValueOfKeyInChilds(key,i);
            }
            i++;
        }
        return null;
    }
    protected ValueType findValueOfKeyInChilds(KeyType key, int i){
        ElementClass tmpElement = table[i];
        while(tmpElement.getNextElement() != null)
        {
            if(tmpElement.getKey() == key)
                return (ValueType) tmpElement.getValue();
            else
                tmpElement = tmpElement.getNextElement();
        }
        return null;
    }
}