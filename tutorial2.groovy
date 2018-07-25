// https://www.timroes.de/2015/06/28/groovy-tutorial-for-java-developers-part2-closures/

// CLOSURES
def helloWorld = {
    println "Hello World"
}

helloWorld()

// If you define a type you can only use this type
def power = { int x, int y ->
    return Math.pow(x,y)
}
println power(2,3)

// you can also skip the type of parameters and pass in anything you want:
def say = {
    what -> println what
}
say "Hello World"
say 1
// If you don't specify any parameters (and no arrow) the closure can accept one parameter which is available by the name it inside of the closure.
def say2 = {
    println it
}
say2 "hola mundo"
// therefore, say and say2 are the same
// if you don't pass the parameter it will be null

// If you really want to create a closure that won't be able to take an argument, you have to write:
def clos = { ->
    println "this closure does not take any arguments."
}
clos()

// OPTIONAL RETURN
def areaSquare = { it * it }
println areaSquare(4)
// This closure makes usage of the implicit parameter it and the optional return statement.

def transform = {str, transformation ->
    transformation(str)
}

println transform("Hello World!", {it.toUpperCase() })
println transform("Hello World!") {it.toUpperCase() }
// due to syntactic sugar, these things are the same

// CLOSING OF VARIABLES
// Closures have access to the variables in the context they were defined.
def createGreeter = { name ->
    return {
        def day = new Date().getDay()
        if(day==0 || day==6) {
            println "Nice weekend, $name"
        } else {
            println "Hello, $name"
        }
    }
}
def greetWorld = createGreeter("World")
greetWorld()
