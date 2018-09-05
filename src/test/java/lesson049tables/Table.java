package lesson049tables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private WebElement tableElement;
    private WebDriver driver;

    public Table (WebElement tableElement, WebDriver driver) {
        this.tableElement = tableElement;
        this.driver = driver;
    }

    public List<WebElement> getHeaders() {
        WebElement headersRow = tableElement.findElement(By.xpath(".//tr[1]"));
        List<WebElement> headers = headersRow.findElements(By.xpath(".//th"));
        return headers;
    }

    public List<WebElement> getRows () {
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr"));
        rows.remove(0); // Removing headers row
        return rows;
    }

    public List<List<WebElement>> getRowsWithColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<>();
        for (WebElement row : rows) {
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public String getValueFromCell (int rowNumber, int columnNumber) {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
        return cell.getText();
    }

    public List<Map<String, WebElement>> getRowsWithColumnsByHeaders() {
        List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
        List<Map<String, WebElement>> rowsWithColumnsByHeaders = new ArrayList<Map<String, WebElement>>();
        Map<String, WebElement> rowByHeaders;
        List<WebElement> headers = getHeaders();

        for (List<WebElement> row : rowsWithColumns) {
            rowByHeaders = new HashMap<String, WebElement>();
            for (int i = 0; i < headers.size(); i++) {
                String header = headers.get(i).getText();
                WebElement cell = row.get(i);
                rowByHeaders.put(header, cell);
            }
            rowsWithColumnsByHeaders.add(rowByHeaders);
        }
        return rowsWithColumnsByHeaders;
    }

    public String getValueFromCell (int rowNumber, String header) {
        List<Map<String, WebElement>> rowsWithColumnsByHeaders  = getRowsWithColumnsByHeaders();
        return rowsWithColumnsByHeaders.get(rowNumber - 1).get(header).getText();
    }

}
