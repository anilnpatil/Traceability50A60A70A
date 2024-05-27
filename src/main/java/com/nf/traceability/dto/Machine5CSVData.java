package com.nf.traceability.dto;

public class Machine5CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double target_torque;
    private Double actual_torque;
    private String pipe_plug_asmbly_status;
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

    public Double getTarget_torque() {
        return target_torque;
    }

    public void setTarget_torque(Double target_torque) {
        this.target_torque = target_torque;
    }

    public Double getActual_torque() {
        return actual_torque;
    }

    public void setActual_torque(Double actual_torque) {
        this.actual_torque = actual_torque;
    }

    public String getPipe_plug_asmbly_status() {
        return pipe_plug_asmbly_status;
    }

    public void setPipe_plug_asmbly_status(String pipe_plug_asmbly_status) {
        this.pipe_plug_asmbly_status = pipe_plug_asmbly_status;
    }
}
