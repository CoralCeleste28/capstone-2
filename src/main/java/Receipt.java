import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt  {

    private final Order order;
    private final LocalDateTime currentTTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
    private final String FILE_PATH = "src/main/resources/receipts/" + currentTTime.format(formatter) + ".txt";

    public Receipt(Order order){
        this.order = order;
    }

    private String prepareReceiptString(){
        return
                "=============================================\n" +
                "                CHIQI'S TACOS NEAR ME\n" +
                "                ORDER RECEIPT\n" +
                "=============================================\n" +
                "";
    }

    public void writeReceipt(){
        String receipt = "";
        try(FileWriter writer = new FileWriter(FILE_PATH, false)){
//            writer.write();
        } catch (IOException e){

        }
    }
}
