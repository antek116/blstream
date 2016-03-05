/**
 *
 * Class used to implements Elements of hashMap
 */
public class ElementClass<TypeKey,TypeValue> implements IElement<TypeKey,TypeValue> {

    private TypeKey key;
    private TypeValue value;
    private ElementClass nextElement;

    ElementClass(TypeKey key,TypeValue value)
    {
        this.key = key;
        this.value = value;
        this.nextElement = null;
    }

    /**
     * Method returning key of element
     * @return Returning Key of element.
     */
    @Override
    public TypeKey getKey() {
        return this.key;
    }

    /**
     *
     * @return  value of element.
     */
    @Override
    public TypeValue getValue() {
        return this.value;
    }
//    /**
//     * No used yet.
//     * @param key
//     * @return
//     */
//    @Override
//    public boolean setKey(TypeKey key) {
//        this.key = key;
//        return true;
//    }
    /**
     * Method setValue to element.
     * @param value value of element;
     * @return  true if value was set;
     */
    @Override
    public boolean setValue(TypeValue value) {
        this.value = value;
        return true;
    }

    /**
     * Method set next Element as children to Element.
     * @param next Reference to next element;
     */
    public void setNextElement(ElementClass next)
    {
        this.nextElement = next;
    }

    /**
     *     /**
     * Method return next Element as children to Element.
     * @return child of element.
     */
    public ElementClass getNextElement(){return this.nextElement;}

}