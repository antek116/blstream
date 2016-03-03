/**
 *
 *  Created by user on 03.03.2016.
 */
public class Main{

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("BlaBla",1);
        map.put("BlaBla1",2);
        map.put("BlaBla2",14);
        System.out.print(map.get("BlaBla1") + "\n");
        map.put("BlaBla3",13);
        map.put("BlaBla4",111);
        map.put("BlaBla4",13);
        map.put("BlaBla4",12);
        map.put("BlaBla5",144);
        map.put("BlaBla6",136);
        map.put("BlaBla7",12);
        map.put("BlaBla8",144);
        map.put("BlaBla9",136);
        map.remove("BlaBla8");
        System.out.print(map.get("BlaBla2") + "\n");
    }
}
