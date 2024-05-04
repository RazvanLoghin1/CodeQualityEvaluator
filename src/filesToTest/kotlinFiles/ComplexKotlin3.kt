package filesToTest.kotlinFiles

class ComplexKotlin3{
    fun updateData(data: MutableList<Int>, updateFunc: (Int) -> Int): MutableList<Int> {
        return data.map(updateFunc).toMutableList()
    }

    fun topLevelFunction(x: Int, y: Int): Int = x * y
}

