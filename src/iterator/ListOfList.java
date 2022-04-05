package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Robbie Sollie - ListOfList.java - EGR326 - CBU - 2019-04-01
 */
public class ListOfList implements Iterator<String> {
    private List<List<String>> list;
    private Iterator outerIter;
    private Iterator<String> innerIter;
    private int innerIndex, outerIndex;

    public ListOfList(List<List<String>> list) {
        this.list = list;
        outerIter = list.iterator();
        innerIndex = 0;
        outerIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return outerIndex < list.size() && innerIndex < list.get(outerIndex).size();
    }

    @Override
    public String next() {
        List<String> innerList = list.get(outerIndex);
        String str = innerList.get(innerIndex++);
        if (innerIndex >= innerList.size()) {
            outerIndex++;
            innerIndex = 0;
        }
        return str;
    }

}
