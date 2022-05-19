import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BigObject {
    private String name;
    private String apiName;
    public static List<BigObject> bigObjectList;
    private List<Field> fieldChildren;

    public BigObject(String name, String apiName) {
        this.name = name;
        this.apiName = apiName;
        bigObjectList.add(this);
    }

    public static BigObject getBigObject(String name){
        BigObject[] objectList = bigObjectList.toArray(new BigObject[bigObjectList.size()]);
        for (int i = 0; i < objectList.length; i++) {
            if (objectList[i].name == name){
                return objectList[i];
            }
        }
        return null;
    }

    public void addFieldChild(Field newfieldChild){
        fieldChildren.add(newfieldChild);
    }

    public List<Field> getFieldChildren(){
        return fieldChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }


}
