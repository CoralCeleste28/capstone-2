import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt  {

    private final Order order;
    private final LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    private final String FILE_PATH = "src/main/resources/receipts/" + now.format(formatter) + ".txt";

    public Receipt(Order order){
        this.order = order;
    }

    public void writeReceipt(){
        try(FileWriter writer = new FileWriter(FILE_PATH, false)){
             writer.write(this.order.toString());
        } catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
