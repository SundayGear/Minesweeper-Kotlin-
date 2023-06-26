package minesweeper

import java.util.Scanner
import kotlin.random.Random

const val DEFAULT_LENGTH = 9
const val DEFAULT_WIDTH = 9

class Game {
    private val mineBoard = Board()

    fun startGame() {
        print("How many mines do you want on the field? > ")
        this.mineBoard.mineAmount = readln().toInt()
        this.mineBoard.showField()
        this.gameLoop()
    }
    private fun checkWin(): Boolean {
        var counterMarkedMine = 0
        var counter = 0
        for (i in 0 until this.mineBoard.field.size)
            for (j in 0 until this.mineBoard.field[0].size) {
                if (this.mineBoard.field[i][j] == "X" && this.mineBoard.viewField[i][j] == "*") {
                    counterMarkedMine++
                }
                if (this.mineBoard.viewField[i][j] == ".") {
                    counter++
                }
            }

        return counterMarkedMine + counter == this.mineBoard.mineAmount
    }


    private fun gameLoop() {
        var createFlag = false
        while (!this.checkWin()) {
            val scan = Scanner(System.`in`)
            print("Set/unset mine marks or claim a cell as free:")
            val xCor = scan.nextInt() - 1
            val yCor = scan.nextInt() - 1
            val isFree:String = when (scan.next()) {
                "mine" -> mineBoard.setMineMark(yCor, xCor)
                "free" -> {
                    if(!createFlag) {
                        this.mineBoard.addMine(yCor, xCor)
                        createFlag = true
                    }
                        mineBoard.openCeil(yCor, xCor)
                }
                else -> "Wrong input"
            }
            if (isFree == "Wrong input") {
                println(isFree)
            } else if (isFree == "/") {
                this.mineBoard.openEmptyCells(yCor, xCor)
            } else if (isFree == "X") {
                this.mineBoard.showField()
                break
            }
            this.mineBoard.showField()
        }
        this.stopGame(this.checkWin())

    }
    private fun stopGame(win: Boolean) {
        if (win) println("Congratulations! You found all the mines!")
        else println("You stepped on a mine and failed!")
    }
}

class Board {
    private val length = DEFAULT_LENGTH
    private val width = DEFAULT_WIDTH
    val field = MutableList(length) { MutableList(width) { "/" } }
    val viewField = MutableList(length) { MutableList(width) { "." } }
    var mineAmount: Int = 0

    private fun cleanUpBoard() {
        for (i in 0 until length)
            for (j in 0 until width){
                this.field[i][j] = "/"
            }

    }

    fun addMine(initX: Int, initY: Int): MutableList<MutableList<String>> {
        this.cleanUpBoard()
        var unplacedMines = this.mineAmount
        while (unplacedMines> 0) {
            val xCor = Random.nextInt(0, this.field.size)
            val yCor = Random.nextInt(0, this.field[0].size)
            if(this.field[xCor][yCor] != "X" && (xCor != initX || yCor != initY)) {
                this.field[xCor][yCor] = "X"
                unplacedMines--
            } else {
                continue
            }
        }
        return markAmountOfMines(this.field)
    }

    private fun countMineAround(i: Int, j: Int, field: MutableList<MutableList<String>>): Int {
        var mineCounter = 0
        val range = 1
        for (k in (i - range) .. (i + range)) {
            for (l in (j - range)..(j + range)) {
                if (k in field.indices && l in field[0].indices) {
                    if (this.field[k][l] == "X") {
                        mineCounter++
                    }
                }
            }
        }
        return mineCounter
    }

    private fun markAmountOfMines (field: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
        for (i in 0 until field.size)
            for (j in 0 until field[0].size) {
                if(this.field[i][j] != "X") {
                    if (countMineAround(i, j, field) != 0) {
                        field[i][j] = countMineAround(i, j, field).toString()
                    }
                    else continue
                } else continue
            }
        return field
    }
    fun setMineMark(xCor: Int, yCor: Int): String {
        if(this.viewField[xCor][yCor] != "." && this.viewField[xCor][yCor] != "*") {
            println("There is a number here!")
        } else if(this.viewField[xCor][yCor] != "*") {
            this.viewField[xCor][yCor] = "*"
        } else {
            this.viewField[xCor][yCor] = "."
        }
        return "-1"
    }

    fun showField () {
        println(" |123456789|")
        println("—|—————————|")
        for (i in 0 until this.viewField.size) { print(i + 1)
            print("|")
            for (j in 0 until this.viewField[i].size){
                print(this.viewField[i][j])
            }
            println("|")
        }
        println("—|—————————|")
    }

    fun openCeil(x: Int, y: Int): String {
        this.viewField[x][y] = this.field[x][y]
        return this.viewField[x][y]
    }
    fun openEmptyCells(x: Int, y: Int) {
        val range = 1
        for (i in x - range..x + range)
            for (j in y - range..y + range) {
                if (i in this.field.indices && j in this.field[0].indices) {
                    if (this.field[i][j] == "/" && this.viewField[i][j] != this.field[i][j]) {
                        this.openCeil(i, j)
                        this.openEmptyCells(i, j)
                    }
                    this.openCeil(i, j)

                }
            }

    }
}



fun main() {
    val minesweeper = Game()
    minesweeper.startGame()

}
