//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
fun main() {
    val rectangle = FieldRectangle(5.0, 3.0)
    val triangle = FieldTriangle(4.0, 6.0)
    val circle = FieldCircle(3.0)
    val family1 = Family(4, rectangle)
    val family2 = Family(3, triangle)
    val family3 = Family(5, circle)
    println("Family 1 per capita area: ${family1.calculatePerCapitaArea()}")
    println("Family 2 per capita area: ${family2.calculatePerCapitaArea()}")
    println("Family 3 per capita area: ${family3.calculatePerCapitaArea()}")
}