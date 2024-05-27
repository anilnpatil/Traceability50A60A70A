package com.nf.traceability.dto;

public class Machine4CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private String pre_screwing_and_screwing_status;
    private String nut_tightening_status;
    private String fail_reason;
    private String cycleTime;

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public String getFail_reason() {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason) {
        this.fail_reason = fail_reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComponent_barcode() {
        return component_barcode;
    }

    public void setComponent_barcode(String component_barcode) {
        this.component_barcode = component_barcode;
    }

    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getProduction_status() {
        return production_status;
    }

    public void setProduction_status(String production_status) {
        this.production_status = production_status;
    }

    public String getPre_screwing_and_screwing_status() {
        return pre_screwing_and_screwing_status;
    }

    public void setPre_screwing_and_screwing_status(String pre_screwing_and_screwing_status) {
        this.pre_screwing_and_screwing_status = pre_screwing_and_screwing_status;
    }

    public String getNut_tightening_status() {
        return nut_tightening_status;
    }

    public void setNut_tightening_status(String nut_tightening_status) {
        this.nut_tightening_status = nut_tightening_status;
    }
}
