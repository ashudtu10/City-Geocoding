package cache;

import lombok.NonNull;
import models.CoOrdinates;

/*
A Caching interface. This can be implemented by various Caching Mechanisms like InMemoryCaching, RedisDistributedCaching
 */
public interface Caching {

    public void addToCache(@NonNull String location, @NonNull CoOrdinates coOrdinates);

    public boolean checkIfExists(@NonNull String location);

    public void removeFromCache(@NonNull  String location);

    public CoOrdinates getFromCache(@NonNull String location);

}
