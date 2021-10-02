package co.com.bancolombia.certificacion.advantage.models;

public class Devices {
    private String so, version,language;

    public Devices(String so, String version, String language) {
        this.so = so;
        this.version = version;
        this.language = language;
    }

    public String getSo() {
        return so;
    }

    public String getVersion() {
        return version;
    }

    public String getLanguage() {
        return language;
    }
}
