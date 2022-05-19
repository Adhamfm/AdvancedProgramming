import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Organizer {
    File file = new File("C:\\Users\\adham\\Desktop\\ASU\\Advanced Programming\\Project\\Example.xlsx");
    FileInputStream fis =new FileInputStream(file);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);
    private String apiName;

    public Organizer() throws IOException {
    }


    public void startOperation(){
        // apiName check
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            XSSFCell firstCell = sheet.getRow(i).getCell(0);
            System.out.println("Checking Row("+sheet.getRow(i).getRowNum()+")");
            if (firstCell == null) continue;
            String firstCellString = firstCell.toString().toLowerCase();
            if (firstCellString != "i" && firstCellString != "o" && firstCellString != "i/o"){
                apiName = firstCellString;
                i += 3; // to skip the HTTP Operation part and not change the api name with it
            }
            XSSFRow currentRow = sheet.getRow(i);
            String typeCell = sheet.getRow(i).getCell(2).toString();
            if (typeCell == "string") {
                System.out.println("Creating Field...");
                createField(currentRow);
            } else {
                System.out.println("Creating Object...");
                createBigObject(currentRow);
            }
        }
    }

    public void createField(XSSFRow currentRow){
        // Get Field Name
        String[] fieldNameCell = currentRow.getCell(1).toString().split("/");
        String fieldName = fieldNameCell[fieldNameCell.length - 1]; //name of field
        // Get ParentObject Name
        String parentObjectName = fieldNameCell[fieldNameCell.length - 2];//name of parentObject
        // Get Allowed Values and If Mandatory
        String[] allowedValues = currentRow.getCell(3).toString().split(",");
        String mandatoryCell = currentRow.getCell(4).toString();
        boolean mandatory = false; // get if mandatory
        if (mandatoryCell.toLowerCase() == "y") mandatory = true;
        else if (mandatoryCell.toLowerCase() == "n") mandatory = false;
        // Get BigObject ParentObject
        BigObject parentObject = BigObject.getBigObject(parentObjectName);
        // Create field
        Field field = new Field(parentObject, fieldName, allowedValues, mandatory);
        System.out.println("Created [Field]: " + field.getName());
        // Add field to ParentObject
        parentObject.addFieldChild(field);
    }

    public void createBigObject(XSSFRow currentRow){
        // name from type
        String bigObjectName = currentRow.getCell(2).toString();

        BigObject parentObject = new BigObject(bigObjectName, apiName);
        System.out.println("Created [Object]: " + parentObject.getName());
    }

}
