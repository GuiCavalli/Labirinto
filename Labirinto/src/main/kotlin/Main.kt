package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val maze = arrayOf(
        arrayOf('|', '|', '|', '|', '|'),
        arrayOf('|', 'P', ' ', ' ', '|'),
        arrayOf('|', '|', ' ', '|', '|'),
        arrayOf('|', ' ', ' ', 'S', '|'),
        arrayOf('|', '|', '|', '|', '|')
    )

    var playerX = 1
    var playerY = 1

    while (true) {
        printMaze(maze)
        print("Movimento (W/A/S/D): ")
        val input = readLine()?.uppercase() ?: continue
        val (newX, newY) = when (input) {
            "W" -> Pair(playerX - 1, playerY)
            "S" -> Pair(playerX + 1, playerY)
            "A" -> Pair(playerX, playerY - 1)
            "D" -> Pair(playerX, playerY + 1)
            else -> continue
        }

        if (maze.getOrNull(newX)?.getOrNull(newY) != '|' && maze.getOrNull(newX)?.getOrNull(newY) != null) {
            if (maze[newX][newY] == 'S') {
                println("Você venceu!")
                break
            }

            maze[playerX][playerY] = ' '
            playerX = newX
            playerY = newY
            maze[playerX][playerY] = 'P'
        }
    }
}

fun printMaze(maze: Array<Array<Char>>) {
    println()
    for (row in maze) {
        println(row.joinToString(" "))
    }
    println()
}

