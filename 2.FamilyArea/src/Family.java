import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Family {
//    String familyName;
    int membersCount;
    double totalArea;
    Map<String, Double> membersArea;
    Map<String, FieldArea> fields;
    List<String> membersNames;

    public Family(){
        this.membersCount = 0;
        this.totalArea = 0;
        this.membersArea = new ConcurrentHashMap<String, Double>();
        this.fields = new ConcurrentHashMap<String, FieldArea>();
        this.membersNames = new ArrayList<>();
    }

    public void addMember(String name, FieldArea area){
        this.membersCount++;
        this.totalArea += area.area;
        this.membersArea.put(name, area.area);
        this.fields.put(name, area);
        this.membersNames.add(name);
    }

    public double getTotalArea(){
        return this.totalArea;
    }

    public double getAverageArea(){
        if(this.membersCount == 0){
            return 0;
        }
        return this.totalArea / this.membersCount;
    }
}
