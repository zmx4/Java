public class RecGround extends Ground{
        private double length;
        private double width;
        public RecGround(double length,double width){
                this.length=length;
                this.width=width;
        }
        public double calArea(){
                return length*width;
        }
        public double calPerimeter(){
                return 2*(length+width);
        }
}