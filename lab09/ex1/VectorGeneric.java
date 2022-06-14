//Nome: Diogo Mendes & Lara Matos;
//Grupo: 503

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}
    public Iterator<T> Iterator(){
        return (this).new VectorIterator<T>();
    }
    public ListIterator<T> ListIterator(){
        return (this).new VectorListIterator<T>();
    }
    public ListIterator<T> ListIterator(int index){
        return (this).new VectorListIterator<T>(index);
    }


    @SuppressWarnings("unchecked")
    private class VectorIterator<K> implements Iterator<K>{
        private int indice;
        VectorIterator(){
            indice=0;
        }
        @Override
        public boolean hasNext(){
            return (indice < nElem);
        }
        @Override
        public K next(){
            if (hasNext()) return (K)vec[indice++]; //uncheck cast from K to T;
            throw new NoSuchElementException("only "+nElem+" elements");
        }
        @Override
        public void remove(){
            throw new UnsupportedOperationException("operation not supported");
        }
    }
    @SuppressWarnings("unchecked")
    private class VectorListIterator<K> implements ListIterator<K>{
        private int indice;

        VectorListIterator(){
            indice=0;
        }
        VectorListIterator(int indice){
            this.indice=indice;
        }
        @Override
        public void add(K e) {
        }

        @Override
        public boolean hasNext() {
            return (indice < nElem);
        }

        @Override
        public boolean hasPrevious() {
            return (indice >= 0);
        }

        @Override
        public K next() {
            if (hasNext()) return (K)vec[indice++]; //uncheck cast from K to T;
            throw new NoSuchElementException("only "+nElem+" elements");
        }

        @Override
        public K previous() {
            if (hasPrevious()) return (K)vec[indice--]; //uncheck cast from K to T;
            throw new IndexOutOfBoundsException("The index is out of the list bounds");
        }
        @Override
        public int nextIndex() {
            return indice++;
        }
        @Override
        public int previousIndex() {
            return indice--;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("operation not supported");
        }

        @Override
        public void set(K e) {}
    }
}