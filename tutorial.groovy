// https://groovy-playground.appspot.com/
// codealong notes from https://www.timroes.de/2015/06/27/groovy-tutorial-for-java-developers/

println "Hello, World!"

def x = 42
println x.getClass()
println x

x = "hello neota"
println x.getClass()
println x

def y = "great big world"
println "Hello, $y"

def firstname = "Neota"
def lastname = "Moe"
println "Hello ${firstname[0]}. $lastname"

def mls = """this is a
multi-line
string"""

def pattern = ~/a slash must be escaped\/ but backslash, like in a \d does not/
println pattern.getClass()

def matcher = "The Hitchhiker's Guide to the Galaxy" =~/Galaxy/
if(matcher) {
    println "Found the word 'Galaxy'"
}

// The first array index describes the found match and
// the second array index describes which group in the match you would like to access (or 0 for the whole match).
def m = "Groovy is groovy" =~ /(G|g)roovy/
println m[0]     // [Groovy, G]
println m[0][0]  // Groovy
println m[0][1]  // G
println m[1][0]  // groovy
println m[1][1]  // g

if(company.getContact() != null
    && company.getContact().getAddress() != null
    && company.getContact.getAddress().getCountry() == Country.NEW_ZEALAND) {
      println "got it!"
    }
// is the same as
if(company.getContact()?.getAddress()?.getCountry() == Country.NEW_ZEALAND) {
    println "got it again"
}

def name = client.getName() ?: ""
