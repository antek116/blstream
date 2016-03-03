/**
 * Class used to implement HashMap with o(1) access.
 *
 */
public class HashMap<KeyType,ValueType> implements IMap<KeyType,ValueType> {

    private ElementClass[] table; //array of elements;
    private static final int INITIAL_CAPACITY = 4;

//    private ElementClass firstElement;
    private int size;

    HashMap() {
        this.size = 0;
        table = new ElementClass[INITIAL_CAPACITY];
    }

    /**
     * Method delete all Elements in Hashmap.
     */
    @Override
    public void clear() {
        this.table = null;
    }
    /**
     * Method returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key
     */
    @Override
    public Object get(KeyType key) {
        ElementClass element = findElement(key);
        return element.getValue();
    }
    /**
     * Returns true if this map contains no key-value mappings.
     * @return true if this map contains no key-value mappings.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;

    }
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return true or false if value with key is added or not.
     */
    @Override
    public ElementClass put(KeyType key, ValueType value) {
        int hash = hash(key);
        ElementClass<KeyType, ValueType> element = new ElementClass<>(key, value);
        if (key == null) {
            return null;
        }
        if (table[hash] == null) {
            table[hash] = element;
            size++;
        } else {
            findPlaceForElementInArrayOfEntry(element,key,table[hash]);
        }
    return element;
    }

    /**
     * Method used to find place for element if hashcode of element exist in array of entry.
     *
     * @param current current element that we looking to add.
     * @param newKey key of element that we looking to add.
     * @param element head element of array.
     */
    public void findPlaceForElementInArrayOfEntry(ElementClass<KeyType, ValueType> current,
                                                  KeyType newKey,
                                                  ElementClass element) {
        element = findPositionForElementInColumn(element,newKey);
        if(element.getKey().equals(newKey)){
            element.setValue(current.getValue());}
        else{
        element.setNextElement(current);}
    }

    /**
     * method for finding the position of an element to replace.
     * @param current Head element of column.
     * @param key key for mapping.
     * @return Element
     */
    public ElementClass findPositionForElementInColumn(ElementClass current,KeyType key) {
        ElementClass previousElement;
        while (current.getNextElement() != null) {
            if (current.getKey().equals(key)) { //if element exist as head element we just overwrite it.
                return current;
            }
            if (current.getNextElement() == null) { //if its last element in column of index.
                return current;
            } else {
                previousElement = current;
                current = current.getNextElement();
            }
            if(current.getKey().equals(key)){ //if this element exist and element isn't head.
                return previousElement; //returning previous element.
            }
        }
        return current;
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        return size;
    }
    /**
     *  Remove the mapping for the specified key from this map if present.
     * @param key key whose mapping is to be removed from the map
     * @return true if there was no mapping for key
     */
    @Override
    public boolean remove(KeyType key) {
        int hash = hash(key);
        ElementClass elementToRemove =findElement(key);
        if(elementToRemove == null){
            return false;
        }
        if( elementToRemove.getNextElement() == null && table[hash].getKey().equals(key)) {
            table[hash] = null;
                return true;}
        else{
            return removeIfChildrenFind(table[hash],key,hash);
        }
    }

    /**
     * Method find a "way" to remove element if childrens exist.
     * It has three way to delete element:
     * 1) if element is last in column, delete him and setNextElement to null on previous element.
     * 2) if element is child of previous element and has child,
     *    deleting element and setNextElement of previous to nextElement of deleting element.]
     * 3) if element is head in column and has child, deleting this element
     *    and set head to next element of deleted element
     * @param indexOfElementToRemove head of column in array.
     * @param key key that we looking for.
     * @param hash hash of key that we looking for.
     * @return returning true if mapped key exist.
     */
    public boolean removeIfChildrenFind(ElementClass indexOfElementToRemove, KeyType key, int hash){
        ElementClass tmpElementToRemove = indexOfElementToRemove;
        ElementClass previousElement = indexOfElementToRemove;
        while(tmpElementToRemove.getNextElement() != null)
        {
            if(table[hash].getKey().equals(key))            {
                table[hash] = tmpElementToRemove.getNextElement();
                return true;}
            if(tmpElementToRemove.getKey().equals(key)){
                table[hash].setNextElement(tmpElementToRemove.getNextElement());
                return true;}
            else{
                previousElement = tmpElementToRemove;
                tmpElementToRemove = tmpElementToRemove.getNextElement();}
        }
        if(tmpElementToRemove.getKey().equals(key)){
            previousElement.setNextElement(null);
            return true;
        }

        return false;
    }

    /**
     * Method find element which the specified key is mapped,.
     * @param key key of mapping element.
     * @return Element which the specified key is mapped,.
     */
    public ElementClass findElement(KeyType key) {
       int hash = hash(key);
        if(table[hash] == null){
            return null;}
        else{
           return findElementOfTheHash(hash,key);
        }
    }

    /**
     * Methods find elements with the same value of hashCode.
     * @param hash value of hashed key
     * @param key key of element.
     * @return return element with the same value of hashCode if exist.
     */
    public ElementClass findElementOfTheHash(int hash, KeyType key){
        ElementClass elementTmp = table[hash];
        while(elementTmp != null) {
            if (elementTmp.getKey().equals(key)) {
                return elementTmp;
            } else {
                elementTmp = elementTmp.getNextElement();
            }
        }
        return null;
    }

    /**
     * Method to get hash code value for this key.
     * @param key key to hash.
     * @return Returns the hash code value for this key.
     */
    private int hash(KeyType key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }
}
