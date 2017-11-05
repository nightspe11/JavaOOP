package trash;

public enum zOffices {
    DEFAULT_MAIN("CityM, LocationM", "9-20"),
    OFFICE1("City1, Location1", "10-17"),
    OFFICE2("City2, Location2", "9-18");
    private String address;
    private String wHours;

    zOffices(String address, String wHours) {
        this.address = address;
        this.wHours = wHours;
    }

    @Override
    public String toString() {
        return "Offices{" +
                "address='" + address + '\'' +
                ", wHours='" + wHours + '\'' +
                '}';
    }
}
