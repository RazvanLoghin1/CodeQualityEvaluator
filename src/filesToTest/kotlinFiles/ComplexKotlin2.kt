package filesToTest.kotlinFiles

object ComplexKotlin2 {
    fun processMap(keys: List<String>, values: List<Int>): Map<String, Int> {
        val resultMap = mutableMapOf<String, Int>()
        keys.forEachIndexed { index, key ->
            if (index < values.size) {
                resultMap[key] = values[index]
            } else {
                resultMap[key] = 0 // default value if value list is shorter
            }
        }
        return resultMap
    }

    fun String.extensionFunction(count: Int): String {
        return if (count > 0) {
            this.repeat(count)
        } else {
            "Invalid count"
        }
    }

    fun multiplyAndLog(vararg numbers: Int, logger: (String) -> Unit) {
        if (numbers.isEmpty()) {
            logger("No numbers provided")
            return
        }
        val result = numbers.fold(1) { acc, i -> acc * i }
        logger("Result: $result")
    }
}
