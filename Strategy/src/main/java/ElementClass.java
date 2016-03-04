/**
 *
 * Created by user on 03.03.2016.
 */
public class ElementClass<TypeKey,TypeValue> implements IElement<TypeKey,TypeValue> {

    TypeKey key;
    TypeValue value;
    ElementClass nextElement;
    ElementClass previousElement;

    ElementClass(TypeKey key,TypeValue value)
    {
        this.key = key;
        this.value = value;
        this.nextElement = null;
        this.previousElement = null;
    }

    ElementClass(TypeKey key,TypeValue value,ElementClass previous){
        this.key = key;
        this.value = value;
        this.previousElement = previous;
        this.nextElement = null;}

    @Override
    public TypeKey getKey() {
        return this.key;
    }

    @Override
    public TypeValue getValue() {
        return this.value;
    }

    @Override
    public boolean setKey(TypeKey key) {
        this.key = key;
        return true;
    }

    @Override
    public boolean setValue(TypeValue value) {
        this.value = value;
        return true;
    }

    public void setNextElement(ElementClass next)
    {
        this.nextElement = next;
    }
    public void setPreviousElement(ElementClass previous)
    {
        this.previousElement = previous;
    }
    public ElementClass getNextElement(){return this.nextElement;}
    public ElementClass getPreviousElement(){return this.previousElement;}

}
