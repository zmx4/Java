class Family(var memberCount: Int,var field: Field) {
    fun calculatePerCapitaArea(): Double {
        val totalArea = field.calculateArea()
        return if (memberCount > 0) totalArea / memberCount else 0.0
    }
}