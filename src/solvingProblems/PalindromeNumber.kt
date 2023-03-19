package solvingProblems

fun isPalindrome(x: Int): Boolean {

    val reversed = x.toString()
    return reversed==reversed.reversed()


}

fun main(){

    val palindrome = isPalindrome(1410110141)
}