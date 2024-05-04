package filesToTest.kotlinFiles

class ComplexKotlin1 {
    // Enhance calculateSum to include additional conditions and calculations
    fun calculateSum(a: Int, b: Int): Int {
        if (a > b) {
            if (a % 2 == 0) {
                return (a + b) * 2 // Multiply the sum by 2 if 'a' is even
            } else {
                return (a + b) / 2 // Divide the sum by 2 if 'a' is odd
            }
        } else if (a < b) {
            if (b % 2 == 0) {
                return (a - b) - 5 // Subtract 5 from the difference if 'b' is even
            } else {
                return (a - b) + 5 // Add 5 to the difference if 'b' is odd
            }
        } else {
            return a * b // Return product if a and b are equal
        }
    }

    // Modify printDetails to include more complex string handling
    fun printDetails(name: String, vararg details: Any) {
        if (details.isEmpty()) {
            println("$name has no details available.")
        } else {
            val detailString = details.joinToString(separator = ", ") {
                if (it is String && it.length > 10) {
                    it.substring(0, 10) + "..." // Truncate long strings
                } else {
                    it.toString()
                }
            }
            println("$name, details: $detailString")
        }
    }
}
