/**
 *
 * Created by user on 03.03.2016.
 */
public interface IElement<TypeKey,TypeValue> {


    public TypeKey getKey();
    public TypeValue getValue();
    public boolean setKey(TypeKey key);
    public boolean setValue(TypeValue value);

}
