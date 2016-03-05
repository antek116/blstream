
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * Created by user on 04.03.2016.
 */
public class SortedMapTest {

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void testCompare() throws Exception {


        ElementClass<String, Integer> element1 = new ElementClass<String, Integer>("Abc", 12);
        ElementClass<String, Integer> element2 = new ElementClass<String, Integer>("Abc", 13);
        SortedMap.MyComparator Value = new  SortedMap.MyComparator();
        assertEquals(-1,Value.compare(element1.getValue(), element2.getValue()));
    }
    @Test
    public void testObjectsCompare() throws Exception{
        int[] array = {2,3};
        int[] array2 = {3,2};
        ElementClass<String, int[]> element1 = new ElementClass<String, int[]>("Abc", array);
        ElementClass<String, int[]> element2 = new ElementClass<String, int[]>("Abc", array2);
        SortedMap.MyComparator<Integer> Value = new  SortedMap.MyComparator<Integer>();
        assertEquals(-1,Value.compare(element1.getValue()[0],element2.getValue()[0]));
    }
    @Test
    public void testObjectsInObjectsCompare() throws Exception{
        ElementClass<String, Integer> tmpElement1 = new ElementClass<String, Integer>("Abc", 123);
        ElementClass<String,Integer> tmpElement2 = new ElementClass<String, Integer>("ABCD",1);
        ElementClass<String, ElementClass<String, Integer>> element1 =
                new ElementClass<String, ElementClass<String, Integer>>("Abc", tmpElement1);
        ElementClass<String, ElementClass<String, Integer>> element2 =
                new ElementClass<String, ElementClass<String, Integer>>("Abc", tmpElement2);
        SortedMap.MyComparator<Integer> Value = new  SortedMap.MyComparator<Integer>();
        assertEquals(1,Value.compare(element1.getValue().getValue(),element2.getValue().getValue()));
    }
    @Test
    public void shouldReturnElementOfKeyValue() throws Exception{
        SortedMap<String,Integer> map = new SortedMap();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        assertEquals((Integer)1,map.get("BlaBla"));
    }
    @Test
    public void shouldReturNullOfKeyValueIfEmptyMap() throws Exception{
        SortedMap<String,Integer> map1 = new SortedMap();
        assertEquals(null,map1.get("BlaBla"));
    }

    @Test
    public void shouldReturnNulloFKeyValue() throws Exception{
        SortedMap<String,Integer> map = new SortedMap();
        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        assertEquals(null,map.get("ABC"));
    }
//    @Test
//    public void sortByKeyComparatorTest() throws Exception{
//        SortedMap<String,Integer> map = new SortedMap();
//        SortedMap.MyComparator comparator;
////        comparator = new Comparable<>();
//        map.sortByKey(comparator = new SortedMap.MyComparator());
//    }
}