package com.nf.traceability.dto;

public class Machine13CSVData {

    private String date;
    private String time;
    private String component_barcode;
    private String machine_name;
    private String operator_name;
    private String shift;
    private String production_status;
    private Double min_ocv_id_gauge_value;
    private Double max_ocv_id_gauge_value;
    private Double actual_ocv_id_gauge_value;
    private Double min_bap_id_gauge_value;
    private Double max_bap_id_gauge_value;
    private Double actual_bap_id_gauge_value;
    private String id_gauge_status;
    private String ocv_and_bap_asmbly_status;
    private String spring_asmbly_status;
    private String retainer_asmbly_status;
    private String circlip_asmbly_status;
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

    public Double getMin_ocv_id_gauge_value() {
        return min_ocv_id_gauge_value;
    }

    public void setMin_ocv_id_gauge_value(Double min_ocv_id_gauge_value) {
        this.min_ocv_id_gauge_value = min_ocv_id_gauge_value;
    }

    public Double getMax_ocv_id_gauge_value() {
        return max_ocv_id_gauge_value;
    }

    public void setMax_ocv_id_gauge_value(Double max_ocv_id_gauge_value) {
        this.max_ocv_id_gauge_value = max_ocv_id_gauge_value;
    }

    public Double getActual_ocv_id_gauge_value() {
        return actual_ocv_id_gauge_value;
    }

    public void setActual_ocv_id_gauge_value(Double actual_ocv_id_gauge_value) {
        this.actual_ocv_id_gauge_value = actual_ocv_id_gauge_value;
    }

    public Double getMin_bap_id_gauge_value() {
        return min_bap_id_gauge_value;
    }

    public void setMin_bap_id_gauge_value(Double min_bap_id_gauge_value) {
        this.min_bap_id_gauge_value = min_bap_id_gauge_value;
    }

    public Double getMax_bap_id_gauge_value() {
        return max_bap_id_gauge_value;
    }

    public void setMax_bap_id_gauge_value(Double max_bap_id_gauge_value) {
        this.max_bap_id_gauge_value = max_bap_id_gauge_value;
    }

    public Double getActual_bap_id_gauge_value() {
        return actual_bap_id_gauge_value;
    }

    public void setActual_bap_id_gauge_value(Double actual_bap_id_gauge_value) {
        this.actual_bap_id_gauge_value = actual_bap_id_gauge_value;
    }

    public String getId_gauge_status() {
        return id_gauge_status;
    }

    public void setId_gauge_status(String id_gauge_status) {
        this.id_gauge_status = id_gauge_status;
    }

    public String getOcv_and_bap_asmbly_status() {
        return ocv_and_bap_asmbly_status;
    }

    public void setOcv_and_bap_asmbly_status(String ocv_and_bap_asmbly_status) {
        this.ocv_and_bap_asmbly_status = ocv_and_bap_asmbly_status;
    }

    public String getSpring_asmbly_status() {
        return spring_asmbly_status;
    }

    public void setSpring_asmbly_status(String spring_asmbly_status) {
        this.spring_asmbly_status = spring_asmbly_status;
    }

    public String getRetainer_asmbly_status() {
        return retainer_asmbly_status;
    }

    public void setRetainer_asmbly_status(String retainer_asmbly_status) {
        this.retainer_asmbly_status = retainer_asmbly_status;
    }

    public String getCirclip_asmbly_status() {
        return circlip_asmbly_status;
    }

    public void setCirclip_asmbly_status(String circlip_asmbly_status) {
        this.circlip_asmbly_status = circlip_asmbly_status;
    }
}
