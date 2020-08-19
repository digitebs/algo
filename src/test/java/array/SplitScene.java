package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


/*
  split scene as many short scene without the same shot appear in multiple scene.

 */
public class SplitScene {

  List<Integer> lengthEachScene(List<Character> inputList)
  {
    // WRITE YOUR CODE HERE

    HashMap<Character,Integer> hm = new HashMap<>();
    for (int i = 0; i < inputList.size(); i++) {
      hm.put(inputList.get(i),i);
    }
    List<Integer> r = new ArrayList<>();
    int s = 0;
    int e = 0;
    for(int i = 0; i < inputList.size(); i++){
      char c = inputList.get(i);
       if((e = Math.max(hm.get(c),e))== i) {
          r.add(e-s+1);
          s = i+1;
      }
    }

    return r;
  }

  public static void main(String[] args) {
    SplitScene ss = new SplitScene();
    List<Integer> l = ss.lengthEachScene(new ArrayList<>(Arrays.asList('a','b','a','b','c',
        'b','a','c','a','d','e','f','e','g','d','e','h','i','j','h','k','l','i','j')));

    l = ss.lengthEachScene(new ArrayList<>(Arrays.asList('a','b','c')));
    List<Integer>  l2 = ss.lengthEachScene(new ArrayList<>(Arrays.asList('a','b','c','a')));
    l = ss.lengthEachScene(new ArrayList<>(Arrays.asList('z','z','c','b','z','c','h','f','i','h','i')));
    System.out.println(l2);
  }
}
