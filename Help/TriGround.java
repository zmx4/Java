public class TriGround extends Ground{
        private double base;
        private double height;
        private double a;
        private double b;
        private double c;//三角形的三边；
        public TriGround(double base,double height,double a,double b,double c){
                this.base=base;
                this.height=height;
                this.a=a;
                this.b=b;
                this.c=c;
        }
        public double calArea(){
                return base*height/2;
        }
        public double calPerimeter(){
                return a+b+c;
        }
}