class FieldCircle(val radius: Double) : Field() {
    override fun calculateArea(): Double {
        area = Math.PI * radius * radius
        return area
    }
}