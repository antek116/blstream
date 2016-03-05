/**
 * Class used to implement HashMap with o(1) access.
 */
public abstract class HashMap<KeyType, ValueType> implements IMap<KeyType, ValueType> {


    /**
     * array of entry elements.
     */
    protected ElementClass<KeyType,ValueType>[] table;
    /**
     * Capacity of value of hash and array;
     */
    protected static final int INITIAL_CAPACITY = 4;

    //    private ElementClass firstElement;
    private int size;

    HashMap() {
        this.size = 0;
        table = new ElementClass[INITIAL_CAPACITY];
    }

    /**
     * Method delete all Elements in Hashmap
     */
    @Override
    public void clear() {
        this.table = null;
        size=0;
    }



    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings.
     */
    @Override
    public boolean isEmpty() {
        size = size();
        return size == 0;

    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return true or false if value with key is added or not.
     */
    @Override
    public ElementClass<KeyType, ValueType> put(KeyType key, ValueType value) {
        if (key == null) {
            return null;
        }
        int hash = hash(key);
        ElementClass<KeyType, ValueType> element = new ElementClass<KeyType, ValueType>(key, value);
        if (table[hash] == null) {
            table[hash] = element;
        } else {
            findPlaceForElementInArrayOfEntry(element, key, table[hash]);
        }
        return element;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return Returns the number of key-value mappings in this map.
     */
    @Override
    public int size() {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            if (table[i] == null) {
                continue;
            }
            if (table[i] != null) {
                size++;
            }
            if (table[i].getNextElement() != null) {
                size += sizeInColumnTable(table[i]);
            }
        }
        return size;
    }

    /**
     * Used to count elements in
     *
     * @param element First element in column on array;
     * @return number of elements in column.
     */
    public int sizeInColumnTable(ElementClass element) {
        int countElementsInColumn = 0;
        while (element.getNextElement() != null)
            if (element.getNextElement() != null) {
                element = element.getNextElement();
                countElementsInColumn++;
            }
        return countElementsInColumn;
    }

    /**
     * Remove the mapping for the specified key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return true if there was no mapping for key
     */
    @Override
    public boolean remove(KeyType key) {
        int hash = hash(key);
        ElementClass elementToRemove = findElement(key);
        if (elementToRemove == null) {
            return false;
        }
        if (elementToRemove.getNextElement() == null && table[hash].getKey().equals(key)) {
            table[hash] = null;
            return true;
        } else {
            return removeIfChildrenFind(table[hash], key, hash);
        }
    }

    /**
     * Method find element which the specified key is mapped,.
     *
     * @param key key of mapping element.
     * @return Element which the specified key is mapped,.
     */
    protected ElementClass<KeyType,ValueType> findElement(KeyType key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            return findElementOfTheHash(hash, key);
        }
    }

    /**
     * Method to get hash code value for this key.
     *
     * @param key key to hash.
     * @return Returns the hash code value for this key.
     */
    protected int hash(KeyType key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    /**
     * Method used to find place for element if hashcode of element exist in array of entry.
     *
     * @param current current element that we looking to add.
     * @param newKey  key of element that we looking to add.
     * @param element head element of array.
     */

    private void findPlaceForElementInArrayOfEntry(ElementClass<KeyType, ValueType> current,
                                                   KeyType newKey,
                                                   ElementClass<KeyType, ValueType> element) {
        element = findPositionForElementInColumn(element, newKey);
        if (element.getKey().equals(newKey)) {
            element.setValue(current.getValue());
        } else {
            element.setNextElement(current);
        }
    }

    /**
     * method for finding the position of an element to replace.
     *
     * @param current Head element of column.
     * @param key     key for mapping.
     * @return Element
     */
    private ElementClass<KeyType, ValueType> findPositionForElementInColumn(ElementClass current, KeyType key) {
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
            if (current.getKey().equals(key)) { //if this element exist and element isn't head.
                return previousElement; //returning previous element.
            }
        }
        return current;
    }

    /**
     * Method find a "way" to remove element if childrens exist.
     * It has three way to delete element:
     * 1) if element is last in column, delete him and setNextElement to null on previous element.
     * 2) if element is child of previous element and has child,
     * deleting element and setNextElement of previous to nextElement of deleting element.]
     * 3) if element is head in column and has child, deleting this element
     * and set head to next element of deleted element
     *
     * @param indexOfElementToRemove head of column in array.
     * @param key                    key that we looking for.
     * @param hash                   hash of key that we looking for.
     * @return returning true if mapped key exist.
     */
    private boolean removeIfChildrenFind(ElementClass indexOfElementToRemove, KeyType key, int hash) {
        ElementClass tmpElementToRemove = indexOfElementToRemove;
        ElementClass previousElement = indexOfElementToRemove;
        while (tmpElementToRemove.getNextElement() != null) {
            if (table[hash].getKey().equals(key)) {
                table[hash] = tmpElementToRemove.getNextElement();
                return true;
            }
            if (tmpElementToRemove.getKey().equals(key)) {
                table[hash].setNextElement(tmpElementToRemove.getNextElement());
                return true;
            }
                previousElement = tmpElementToRemove;
                tmpElementToRemove = tmpElementToRemove.getNextElement();

        }
        if (tmpElementToRemove.getKey().equals(key)) {
            previousElement.setNextElement(null);
            return true;
        }

        return false;
    }

    /**
     * Methods find elements with the same value of hashCode.
     *
     * @param hash value of hashed key
     * @param key  key of element.
     * @return return element with the same value of hashCode if exist.
     */
    private ElementClass<KeyType,ValueType> findElementOfTheHash(int hash, KeyType key) {
        ElementClass<KeyType,ValueType> elementTmp = table[hash];
        while (elementTmp != null) {
            if (elementTmp.getKey().equals(key)) {
                return elementTmp;
            }
                elementTmp = elementTmp.getNextElement();

        }
        return null;
    }
}