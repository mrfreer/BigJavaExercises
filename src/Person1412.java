import java.util.Arrays;

/**
 * Created by dfreer on 6/29/2017.
 */
class Person implements Comparable<Person> {
    String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    public int compareTo(Person other){
        if(first.compareTo(other.first) == 0){
            return last.compareTo(other.last);
        }
        else{
            return first.compareTo(other.first);
        } //cool

    }

}

public class Person1412 {
    public static void main(String[] args) {
        Person p = new Person("Fred", "Flintstone");
        Person q = new Person("Homer", "Simpson");
        Person r = new Person("George", "Jetson");
        Person s = new Person("Abe", "Timpson");
        Person u = new Person("Abe", "Simpson");
        Person arr[] = {p, q, r, s, u};
        Arrays.sort(arr);
        for(Person t : arr){
            System.out.println(t);
        }
    }
}
