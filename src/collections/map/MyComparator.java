package collections.map;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {
    public int compare(T o1, T o2){
        if ((o1 instanceof Student) & (o2 instanceof Student)){
            if (((Student) o1).age.equals(((Student) o2).age)){
                return 0;
            } else if(((Student) o1).age > ((Student) o2).age){
                return 1;
            };
        }
        return -1;
    }
}
