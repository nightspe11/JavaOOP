package kursach3.storage;

public interface Storable<T, E> { //?? TODO
    /**
     * Returns result by internal List-parameter serch. "s" is multiple match key.
     */
    T select(String s);

    /**
     * Insert object "e" into internal List. Returns initial object.
     */
    T insert(E e);

    /**
     * Delete object "e" from internal List. Returns initial object.
     */
    T delete(E e);
}
