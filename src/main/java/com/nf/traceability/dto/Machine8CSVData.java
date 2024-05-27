package com.nf.traceability.dto;

public class Machine8CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double minimum_torque;
    private Double maximum_torque;
    private Double actual_torque;
    private Double actual_angle;
    private String ball_spring_oring_thread_plug_asmbly_status;
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

    public Double getMinimum_torque() {
        return minimum_torque;
    }

    public void setMinimum_torque(Double minimum_torque) {
        this.minimum_torque = minimum_torque;
    }

    public Double getMaximum_torque() {
        return maximum_torque;
    }

    public void setMaximum_torque(Double maximum_torque) {
        this.maximum_torque = maximum_torque;
    }

    public Double getActual_torque() {
        return actual_torque;
    }

    public void setActual_torque(Double actual_torque) {
        this.actual_torque = actual_torque;
    }

    public Double getActual_angle() {
        return actual_angle;
    }

    public void setActual_angle(Double actual_angle) {
        this.actual_angle = actual_angle;
    }

    public String getBall_spring_oring_thread_plug_asmbly_status() {
        return ball_spring_oring_thread_plug_asmbly_status;
    }

    public void setBall_spring_oring_thread_plug_asmbly_status(String ball_spring_oring_thread_plug_asmbly_status) {
        this.ball_spring_oring_thread_plug_asmbly_status = ball_spring_oring_thread_plug_asmbly_status;
    }
}