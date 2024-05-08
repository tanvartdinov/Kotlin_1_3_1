fun main() {
    for(n in 1..61){
        print("$n c -> ")
        agoToText(n)
    }
    for(n in 61..3601 step 60){
        print("${n / 60} м -> ")
        agoToText(n)
    }
    for(n in 3601..(3600 * 96) step 3600){
        print("${n / 3600} ч -> ")
        agoToText(n)
    }
}

fun agoToText(seconds: Int) = when (seconds) {
    in 0..60 -> println("был(а) только что")
    in 61..(60 * 60) -> println("был(а) ${calcMinutes(seconds)} назад")
    in (60 * 60 + 1)..(24 * 60 * 60) -> println("был(а) ${calcHours(seconds)} назад")
    in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> println("был(а) вчера")
    in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> println("был(а) позавчера")
    in (3 * 24 * 60 * 60 + 1)..Int.MAX_VALUE -> println("был(а) давно")
    else -> println("Время не может быть отрицательным")
}

fun calcMinutes(seconds: Int): String {
    val minutes = seconds / 60
    return when {
        minutes in 10..19 -> "$minutes минут"
        minutes % 10 == 1 -> "$minutes минуту"
        minutes % 10 in 2..4 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun calcHours(seconds: Int): String {
    return when (val hours = seconds / (60 * 60)) {
        1, 21 -> "$hours час"
        in 5..20 -> "$hours часов"
        else -> "$hours часа"
    }
}