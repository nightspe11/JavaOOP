package kursach2.storage.offices;

public class Office {
    private static int officeCount = 1;
    private final String officeId;
    private final String title;
    private String address;
    private String wHours;

    public Office(String officeID, String title, String address, String wHours) {
        this.officeId = officeID;
        this.title = title;
        this.address = address;
        this.wHours = wHours;
    }

    public Office(String title, String address, String wHours) {
        this.officeId = "" + officeCount++;
        this.title = title;
        this.address = address;
        this.wHours = wHours;
    }

    public Office(String address) {
        this("Office" + officeCount, address, "9-18");
    }

    public static int getOfficeCount() {
        return officeCount;
    }

    public String getOfficeID() {
        return officeId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getwHours() {
        return wHours;
    }

    @Override
    public String toString() {
        return "Office{" +
                "officeID=" + officeId +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", wHours='" + wHours + '\'' +
                '}';
    }
}
