package cache;


import lombok.NonNull;
import models.CoOrdinates;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCache implements Caching {

    private static InMemoryCache cacheSingleton;

    private Map<String, CoOrdinates> cacheMap;

    private InMemoryCache() {
        cacheMap = new ConcurrentHashMap<>();
    }

    public static InMemoryCache getInMemoryCache() {
        if(cacheSingleton==null) {
            synchronized (InMemoryCache.class) {
                if(cacheSingleton==null) {
                    cacheSingleton = new InMemoryCache();
                }
            }
        }
        return cacheSingleton;
    }

    @Override
    public void addToCache(@NonNull String location, @NonNull CoOrdinates coOrdinates) {
        cacheMap.put(location,coOrdinates);
    }

    @Override
    public boolean checkIfExists(@NonNull String location) {
        if(cacheMap.containsKey(location))
            return true;
        return false;
    }

    public CoOrdinates getFromCache(@NonNull String location) {
        if(checkIfExists(location))
            return cacheMap.get(location);
        return null;
    }

    @Override
    public void removeFromCache(@NonNull String location) {
        cacheMap.remove(location);
    }
}
