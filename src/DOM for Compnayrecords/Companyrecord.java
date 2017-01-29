import java.util.ArrayList;

public class Companyrecord{

    private String name;

    private ArrayList<Record> records;

    public Companyrecord() {
        this.records = new ArrayList<Record>();
    }

    public Record getRecord(int num) {
        return records.get(num);
    }

    public int getRecordSize() { return records.size();}


    public void addRecord(Record record) {
        records.add(record);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
