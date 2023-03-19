package solvingProblems

fun romanToInt(s: String): Int {
    var roman = 0

    val hash=HashMap<Char,Int>()

    //initialize The Roman Numbers
    hash['I']=1
    hash['V']=5
    hash['X']=10
    hash['L']=50
    hash['C']=100
    hash['D']=500
    hash['M']=1000

    var i =0
    while (i<s.length-1){
       if (hash[s[i]]!! >= hash[s[i+1]]!!){ //
           roman+= hash[s[i]]!!
           i++


       } else{
            roman+=hash[s[i+1]]!!-hash[s[i]]!!

           i+=2

        }
    }

    if (i==s.length-1)roman+=hash[s[i]]!!
    return roman
}

fun main(){

  val r=romanToInt("MCMXCIV")
}