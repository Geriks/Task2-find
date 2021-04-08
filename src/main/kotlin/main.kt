import java.io.File
import kotlin.system.exitProcess

//Поиск файла(ов) с заданным в командной строке именем в указанной ключом -d директории,
//по умолчанию в текущей директории. Ключ -r указывает на необходимость поиска также во всех поддиректориях.
//
//Command Line: find [-r] [-d directory] filename.t

fun main(args : Array<String>) {
    var recursive = false
    var path = "."
    var i = 0
    while (i < args.size - 1) {
        when (args[i]) {
            "-r" -> {
                recursive = true
            }
            "-d" -> {
                path = args[i + 1]
                i++
            }
            else -> {
                println("Неизвестный аргумент ${args[i]}")
                exitProcess(1)
            }
        }
        i++
    }
    if (i == args.size) {
        println("Не задано имя файла")
        exitProcess(1)
    }
    searchFile(args.last(), File(path), recursive)
}


fun searchFile(name: String,path: File,recursive: Boolean){
    val directoryFile = path.listFiles()
    if (recursive) {
        if (path.isDirectory) {
            if (directoryFile != null) {
                for (i in directoryFile) {
                    if (i.isDirectory)
                        searchFile(name, path, true)
                    if (name == i.name) println(i.path + " - " + name)
                }
            }
        }
    } else {
        if (directoryFile != null) {
            for (i in directoryFile)
                if (name == i.name) println(i.path + " - " + name)
        }
    }
}
