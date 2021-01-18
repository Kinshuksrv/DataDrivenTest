import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataDrivenTest {

    public String getCellData(String column, int row) throws IOException {

        // open and switch to the spreadsheet which has data
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Book2.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("sample");

        // get the header row and store the column Name with the column index in a Map
        Map<String,Integer> map = new HashMap();
        Iterator<Row> rows = sheet.iterator();
        Row headerRow = rows.next();
        Iterator<Cell> cell = headerRow.cellIterator();
        while(cell.hasNext()){
            Cell cellValue = cell.next();
            map.put(cellValue.getStringCellValue(),cellValue.getColumnIndex());
        }

        // get the value from the specific cell which has AccountId and TransactionId
        Row r = sheet.getRow(1);
        Cell c = r.getCell(map.get(column));  //r.getCell(TransactioID) == r.getCell(1) == 12145
        if(c.getCellTypeEnum()== CellType.STRING){
            return c.getStringCellValue();
        }

        else{
            return NumberToTextConverter.toText(c.getNumericCellValue());
        }


    }
}
