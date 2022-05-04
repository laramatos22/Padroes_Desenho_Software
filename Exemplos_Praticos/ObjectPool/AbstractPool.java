package ObjectPool;

public class AbstractPool implements Pool {
    
    protected final int MAX_FREE_OBJECT_INDEX;
    protected PooledObjectFactory factory;
    protected PooledObject[] freeObjects;
    protected int freeObjectIndex = -1;

    /**
    * @param factory the object pool factory instance
    * @param maxSize the maximum number of instances stored in the pool
    */
    public AbstractPool(PooledObjectFactory factory, int maxSize)
    {
        this.factory = factory;
        this.freeObjects = new PooledObject[maxSize];
        MAX_FREE_OBJECT_INDEX = maxSize - 1;
    }

    /**
    * Creates a new object or returns a free object from the pool.
    * @return a PooledObject instance already initialized
    */
    public synchronized PooledObject newObject() {
        PooledObject obj = null;
        if (freeObjectIndex == -1) {
            // There are no free objects so I just
            // create a new object that is not in the pool.
            obj = factory.getInstance();
        } else {
            // Get an object from the pool
            obj = freeObjects[freeObjectIndex];
            freeObjectIndex--;
        }
        obj.initializePooledObject();
        return obj;
    }

    /**
    * Stores an object instance in the pool to make it available for a subsequent
    * call to newObject() (the object is considered free).
    * @param obj the object to store in the pool and that will be finalized
    */
    public synchronized void freeObject(PooledObject obj)
    {
        if (obj != null)
        {
            // Finalize the object
            obj.finalizePooledObject();
            // put an object in the pool only if there is still room for it
            if (freeObjectIndex < MAX_FREE_OBJECT_INDEX) {
                freeObjectIndex++;
                // Put the object in the pool
                freeObjects[freeObjectIndex] = obj;
            }
        }
    }

}
