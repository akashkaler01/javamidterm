public class Diagnosis {

    private String patientName;
    private String diagnosis;

    public Diagnosis(String patientName, String diagnosis) {
        this.patientName = patientName;
        this.diagnosis = diagnosis;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
