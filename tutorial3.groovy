// https://www.timroes.de/2015/06/28/groovy-tutorial-for-java-developers-part3-collections/

// COLLECTIONS

def list = [1,1,2,3,5,6,11]

println list[0]
println list[-1]  // negative indexes access from the end of the list

if(5 in list) {
    println "found 4"
}

list.each {
    println it
}

def even = list.findAll { it % 2 == 0 }

// Note that all of these methods work on any Java Collection.
// No matter if you created it the short way as shown above or
// if comes from a Java part of your program and has been created the "traditional" way.

def squaredList = list.collect { it * it }
println squaredList
// This will create a new list by transforming each element in list by the given closure.

// If the only transformation you want to do in the collect closure is calling a method on each element, like in the following:
def upper = ["Hello", "World"].collect {it.toUpperCase()}
// you can use a spread-dot opertor and instead write:
def upper2 = ["Hello", "World"]*.toUpperCase()

// MAPS
def myKey = 'Key3'
def aMap = [
    'Key1': 'Value 1',
    Key2: 'Value 2',  // can skip quotes, key will automatically be string
    (myKey): 'Another Value',  // use parentheses to use value of variable as key
    'Key with spaces': 'Value 4'
]
println aMap['Key1']
println aMap[myKey]
println aMap.Key1
println aMap.'Key with spaces'  // dot notation and accessing key with spaces
println aMap."$myKey" // dot notation and interpolated strings

println '--------'

// using each you get the entry of the map so you can access the key and value
aMap.each {
    // println it.key + ":" + it.value
    println it.key
    println it.value
}

println '--------'

// The each method can also take a closure with two parameters in which case it will put key and value into these parameters.
aMap.each { key, value ->
    println key
    println value
}

// The only method that behaves quite different is the collect method.
// The collect method will (also on maps) create a list as an output.
// It will iterate over all entries in the map and pass them (as a single
// or as two parameters) to the closure. The objects you return from the
// closure will be added all to a list (and not a map).
aMap.collect{ return it }
// this will give you an ArrayList of Map entries.  Use this if you want to collect
// a map to a list of values

// to make a map into another map, use collectEntries - this is creating the same map again
aMap.collectEntries {
    return it
}

// this is also the same thing
aMap.collectEntries { key, value ->
    return [(key): value]
}

def doubleMap = [
    Key1: 2,
    Key2: 3,
    Key3: 4,
    Key4: 5
]

// you can return a map with more than one entry
def doubleMap2 = doubleMap.collectEntries { key, value ->
    def newKey = key + "^2"
    return [(key): value, (newKey): value*value]
}

doubleMap2.each{
    println it.key + " : " + it.value
}
