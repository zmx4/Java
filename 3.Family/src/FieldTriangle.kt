class FieldTriangle(var base:Double ,var height: Double) :Field() {
    override fun calculateArea(): Double {
        area = 0.5 * base * height
        return area
    }
}