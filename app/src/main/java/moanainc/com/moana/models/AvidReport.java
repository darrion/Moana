package moanainc.com.moana.models;

/**
 * Created by darrion on 2/28/17.
 */

public class AvidReport implements Report {
    @Override
    public Report createReport() {
        return new AvidReport();
    }
}
