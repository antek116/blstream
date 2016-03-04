
/**
 *
 *  Created by user on 03.03.2016.
 */
public interface ISortedMap<TypeKey,TypeValue>{

        public enum Order{
            ASC,DESC
        }
        public ISortedMap sortByKey(Order order);
        public ISortedMap sortByValue(Order order);





}
