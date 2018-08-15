import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.row

class MainTest : StringSpec({
    val main: Main = Main()
    "transform should return one for one"{
        val result = main.transform("1")
        result shouldBe "11"
    }
    "transform should return two one for oneOne"{
        val result = main.transform("11")
        result shouldBe "21"
    }
    "transform should return valid values for the first two iteration"{
        forall(row("1", "11"),
                row("11", "21"),
                row("222", "32"),
                row("2211", "2221"),
                row("1234", "11121314"),
                row("11121314", "311211131114"),
                row("222222222222", "122")
        ) { a, b ->
            main.transform(a) shouldBe b
        }
    }
    "lookAndSay should iterate through multiple transforms"{
        forall(row("31121", 3, "31131122212211")
        ) { a, b, c ->
            main.lookAndSay(a, b) shouldBe c
        }
    }
    "transformBackward should return oneOne one for twoOne"{
        val result = main.transformBackward("21")
        result shouldBe "11"
    }
})