class FieldRectangle(var length: Double,var width: Double) : Field() {
    override fun calculateArea(): Double {
        area = length * width
        return area
    }
}