package ObjectPool;

/**
 * Interface that has to be implemented by an object that can
 * be stored in an object pool through the Pool class
 */

public interface PooledObject {

    /**
     * Initialization method. Called when an object is retrieved
     * from the object pool or has just been created.
     */
    public void initializePooledObject();

    /**
     * Finalization method. Called when an object is stored in the
     * object pool to mark it as free.
     */
    public void finalizePooledObject();
    
}
