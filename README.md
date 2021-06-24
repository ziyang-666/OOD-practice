# HashMap
Description: this is a practie to implement seperate chaining hashmap in java

## API
* + size() : int
* + isEmpty(): boolean
* + containsKey(K) : boolean
* + containsValue(V) : boolean
* + put(K, V): V
* + remove(K) : V

## Fields
* - size: int
* - load_factor: float
* - array : Entry<K, V>[]

## Processes of implementation
1. Define the class for each entry
2. maintain an array of entries
3. hash(key) to get the hash#
4. from the hash#, mapped to the entry index
5. when iterate the corresponding entry for the given key, which is actually a singly linked list, we nned compare each of the entry in the list, if the key is the same as the key we want

## Discuss the possible data race and improve hashmap as a thread safe hashmap
* entry's value's api
* size api
* isEmpty api
* put api
* get api
* containsKey api
* containsValue api
* remove api


 
