fun mathOperation() {
    print("2x*x + 4x + 10 ")
    print("Enter x value: ")
    var x:Int = readLine()
    var  res:Int = 0
    if (x > 0) {
        res = 2 * x * x + 4 * x + 10
    }
    print("Result: ")
    print(res)
}

fun arrayCheck() {
    var numbers: Array<Int> = arrayOf(133, 22, 3, 41, 5)
    print("Old array value: ")
    print(numbers[0])
    print(" ")
    numbers[0] = 12
    print("New array value: ")
    print(numbers[0])
}


fun main() {
   print("Kotlin Compiler!")
    mathOperation()
    arrayCheck()
}