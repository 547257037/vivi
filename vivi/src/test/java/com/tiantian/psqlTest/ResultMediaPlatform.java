package com.tiantian.psqlTest;


public class ResultMediaPlatform {

    private String operatorId;
    private String instanceId;
    private String position;
    private String PV;
    private String PV_AVG;
    private String status;

    public ResultMediaPlatform() {
    }

    public ResultMediaPlatform(String operatorId, String instanceId, String position, String PV, String PV_AVG, String status) {
        this.operatorId = operatorId;
        this.instanceId = instanceId;
        this.position = position;
        this.PV = PV;
        this.PV_AVG = PV_AVG;
        this.status = status;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPV() {
        return PV;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

    public String getPV_AVG() {
        return PV_AVG;
    }

    public void setPV_AVG(String PV_AVG) {
        this.PV_AVG = PV_AVG;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultMediaPlatform{" +
                "operatorId='" + operatorId + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", position='" + position + '\'' +
                ", PV='" + PV + '\'' +
                ", PV_AVG='" + PV_AVG + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
