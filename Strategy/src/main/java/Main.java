/**
 *
 *  Created by user on 03.03.2016.
 */
public class Main{

    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        map.remove("BlaBla1");
        map.put("BlaBla3",13);
        System.out.print(map.get("BlaBla2"));
    }
}
