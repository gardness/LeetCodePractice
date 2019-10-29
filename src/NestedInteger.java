import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    Integer value;
    List<NestedInteger> list;

    NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    }

    NestedInteger(int value) {
        this.value = value;
    }

    NestedInteger(int value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() { return true; }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() { return 0; }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) { return; }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) { return; }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() { return null; }

}
