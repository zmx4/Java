public class Family{
        private int member;
        private Ground ground;
        public Family(int member,Ground ground){
                this.member=member;
                this.ground=ground;
        }
        public double getArea(){
                return ground.calArea();
        }
        public double getPerArea(){
                return getArea()/member;
        }
        public double getPerimeter(){
                return ground.calPerimeter();
        }
}
                