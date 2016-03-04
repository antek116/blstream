/**
 *
 * Created by user on 03.03.2016.
 */
public class HashMap<KeyType,ValueType> implements IMap<KeyType,ValueType> {

    private ElementClass<KeyType, ValueType>[] table; //array of elements;
    private static int capacityOfHashValue = 4;

    ElementClass firstElement;
    ElementClass lastElement;
    int size;

    HashMap() {
        this.size = 0;
        table = new ElementClass[capacityOfHashValue];
    }


    @Override
    public void clear() {
        this.firstElement = null;
    }

    @Override
    public ValueType get(KeyType key) {
        ElementClass element = findElement(key);
        return (ValueType) element.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @Override
    public ElementClass put(KeyType key, ValueType value) {
//        int hash = hash(key);
        int hash = 0;
        ElementClass element = new ElementClass(key, value);
        if (key == null) {
            return null;
        }
        if (table[hash] == null) {
            table[hash] = element;
            size++;
        } else {
            findPlaceForElementInArrayOfEntry(null, element, hash, key, element);
        }
    return element;

//        if(isEmpty()){
//          int hascode =  hash(key);
//           firstElement = new ElementClass(key,value);
//           lastElement = firstElement;
//           size++;
//           return firstElement;}
//        else
//        {
//           int hascode =  hash(key);
//           ElementClass newLast = null;
//           if(lastElement != firstElement){
//                newLast = new ElementClass(key,value,lastElement.getPreviousElement());}
//           else{
//                newLast = new ElementClass(key,value,firstElement);}
//           lastElement.setNextElement(newLast);
//           lastElement = newLast;
//           size++;
//           return lastElement;
//        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(KeyType key) {
        ElementClass elementToRemove = findElement(key);
        if (elementToRemove == lastElement) {
            elementToRemove.getPreviousElement().setNextElement(null);
            size--;
            return true;
        } else if (elementToRemove == firstElement) {
            elementToRemove.getNextElement().setPreviousElement(null);
            size--;
            return true;
        } else {
            elementToRemove.getPreviousElement().setNextElement(elementToRemove.getNextElement());
            elementToRemove.getNextElement().setPreviousElement(elementToRemove.getPreviousElement());
            size--;
            return true;
        }
    }

    public ElementClass findElement(KeyType key) {
        int i = 0;
        ElementClass element = firstElement;
        while (i != size) {
            if (element.getKey() == key) {
                return element;
            } else {
                element = element.nextElement;
            }
        }
        return null;
    }

    private int hash(KeyType key) {
        return Math.abs(key.hashCode()) % capacityOfHashValue;
    }

    public void findPlaceForElementInArrayOfEntry(ElementClass<KeyType, ValueType> previous,
                                                  ElementClass<KeyType, ValueType> current,
                                                  int hash, KeyType newKey,
                                                  ElementClass<KeyType, ValueType> element) {
        while (current != null) { //we have reached last entry of bucket.
            if (current.key.equals(newKey)) {
                if (previous == null) {  //node has to be insert on first of bucket.
                    element.setNextElement(current.getNextElement());
                    table[hash] = element;
                    return;
                } else {
                    element.setNextElement(current.getNextElement());
                    previous.setNextElement(element);
                    return;

                }
            }
        }
    }
}
