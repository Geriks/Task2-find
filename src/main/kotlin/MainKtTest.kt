import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream


internal class MainKtTest {

    private val out = ByteArrayOutputStream()
    private val originOut = System.out
    private val sep = System.lineSeparator()

    @BeforeEach
    fun initConsole() {
        System.setOut(PrintStream(out))
    }

    @AfterEach
    fun afterConsole(){
        System.setOut(originOut)
    }

    @Test
    fun searchFile() {

        searchFile("main.kt", File("src\\main\\kotlin"),true)
        assertEquals("src\\main\\kotlin\\main.kt - main.kt$sep",out.toString())
        out.reset()
        searchFile("main.kt",File("src\\main\\kotlin"),false)
        assertEquals("src\\main\\kotlin\\main.kt - main.kt$sep",out.toString())
        out.reset()
        searchFile("Testfile", File("."),false)
        assertEquals(".\\Testfile - Testfile$sep",out.toString())
        out.reset()
    }
}