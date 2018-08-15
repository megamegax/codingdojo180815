class Main {

    fun transform(input: String): String {
        var outputString = ""
        var lastChar: Char? = null
        var numberOfLastChar = 1
        input.forEach {
            if (lastChar != it) {
                outputString = addGroup(outputString, lastChar, numberOfLastChar)
                numberOfLastChar = 1
                lastChar = it
            } else {
                numberOfLastChar++
            }
        }
        return addGroup(outputString, lastChar, numberOfLastChar)
    }

    private fun addGroup(originalString: String, char: Char?, numberOfChars: Int): String {
        var result = originalString
        if (char != null) {
            result += "$numberOfChars$char"
        }
        return result
    }

    fun lookAndSay(input: String, n: Int): String {
        var output = input
        for (i in 1..n) {
            output = transform(output)
        }
        return output
    }

    fun transformBackward(input: String): String {
        var output = ""
        for (i in 0..input.length step 2) {
            val number = input[i]
            val value = input[i + 1]
            output += "$number$value"
        }
        return output
    }
}