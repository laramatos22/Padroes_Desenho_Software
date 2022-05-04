package ObjectPool;

/**
 * Interface that has to be implemented by every class that
 * allows the acreation of objects for an object pool
 * through the Pool class.
 */

public class PooledObjectFactory {

    /**
     * Creates a new object for the object pool.
     * 
     * @return new object instance for the object pool
     */
    public PooledObject getInstance();
    
}
