package myAbstractCollection;

import java.util.*;
import java.util.ArrayList;


/**
 * Created by egc on 3/12/2017.
 */
public class MyAbstractCollection<E> extends AbstractCollection<E>{

    //private List<Object> list =new ArrayList<Object>();




    @Override
    public Iterator iterator(){
        throw new UnsupportedOperationException();
    }
    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    public boolean appendAnything(MyAbstractCollection obj1,MyAbstractCollection obj2){

        obj1.addAll(obj2);

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> colle) {
        boolean statu = false;
        for (E e : colle)
            if (add(e))
                statu = true;
        return statu;

    }

    @Override
    public boolean add(Object o) {

        throw new UnsupportedOperationException();
    }
}
