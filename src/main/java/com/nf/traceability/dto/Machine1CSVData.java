package com.nf.traceability.dto;

public class Machine1CSVData {
    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private String bap_hole_status;
    private String thread_plug_hole_status;
    private String pipe_plug_hole_status;
    private String ocv_hole_status;
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

    public String getBap_hole_status() {
        return bap_hole_status;
    }

    public void setBap_hole_status(String bap_hole_status) {
        this.bap_hole_status = bap_hole_status;
    }

    public String getThread_plug_hole_status() {
        return thread_plug_hole_status;
    }

    public void setThread_plug_hole_status(String thread_plug_hole_status) {
        this.thread_plug_hole_status = thread_plug_hole_status;
    }

    public String getPipe_plug_hole_status() {
        return pipe_plug_hole_status;
    }

    public void setPipe_plug_hole_status(String pipe_plug_hole_status) {
        this.pipe_plug_hole_status = pipe_plug_hole_status;
    }

    public String getOcv_hole_status() {
        return ocv_hole_status;
    }

    public void setOcv_hole_status(String ocv_hole_status) {
        this.ocv_hole_status = ocv_hole_status;
    }
}
