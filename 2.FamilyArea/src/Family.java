import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Family {
//    String familyName;
    public int membersCount;
    public double totalArea;
    public Map<String, Double> membersArea;
    public Map<String, FieldArea> fields;
    public List<String> membersNames;

    public Family(){
        this.membersCount = 0;
        this.totalArea = 0;
        this.membersArea = new ConcurrentHashMap<>();
        this.fields = new ConcurrentHashMap<>();
        this.membersNames = new CopyOnWriteArrayList<>();
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
