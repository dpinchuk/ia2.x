package models;

/**
 * Class of TasLink model
 */

public final class TasLinkModel {

    private String sid;

    private TasLinkModel(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public static TasLinkModel getInstance(String sid) {
        return new TasLinkModel(sid);
    }

}