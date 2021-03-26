import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import java.io.File


internal class MainKtTest {

    @Test
    fun main() {
        try {
            arrayOf("")
        } catch (e:Exception){
            println("Не задано имя файла")}
        try {
            arrayOf("-abcd")
        } catch (e:Exception){
            println("Неизвестный аргумент")}
        try {
            arrayOf("abcd -d Testolder\\testfolder1")
        } catch (e:Exception){
            println("Файл не найден")
        }
    }

    @Test
    fun searchFile() {
        assertEquals("""src\main\kotlin\main.kt - main.kt""",searchFile("main.kt", File("src\\main\\kotlin"),true))
        assertEquals("""src\main\kotlin\main.kt - main.kt""",searchFile("main.kt",File("src\\main\\kotlin"),false))
        assertEquals(""".\Testfile - Testfile""",searchFile("Testfile", File("."),false))
    }
}
