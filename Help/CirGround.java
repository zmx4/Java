public class CirGround extends Ground{
        private double rad;
        public CirGround(double rad){
                this.rad=rad;
        }
        public double calArea(){
                return 3.14*rad*rad;
        }
        public double calPerimeter(){
                return 2*3.14*rad;
        }
}