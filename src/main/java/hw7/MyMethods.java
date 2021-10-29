package hw7;

public class MyMethods implements Comparable{
    private String name;
    private int priority;

    public MyMethods(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Object o) {
        MyMethods another = (MyMethods)o;
        if (this.priority > another.priority) {
            return 1;
        }
        if (this.priority < another.priority) {
            return -1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
