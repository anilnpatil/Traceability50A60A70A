package com.nf.traceability.dto;

public class Machine19 {
    private String sflPartId;
    private String productId;
    private Integer process1PassFail;
    private Double process1Parameter1;
    private Double process1Parameter2;
    private Double process1Parameter3;
    private Integer status;
    private Integer okParts;
    private Integer notOkParts;
    private Integer currentShift;
    private Integer totalProduction;
    private Integer shift;
    private Integer totalProductionCount;
    private String startTime;
    private String endTime;
    private String cycleTime;

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public Integer getTotalProductionCount() {
        return totalProductionCount;
    }

    public void setTotalProductionCount(Integer totalProductionCount) {
        this.totalProductionCount = totalProductionCount;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(String cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Integer getOkParts() {
        return okParts;
    }

    public void setOkParts(Integer okParts) {
        this.okParts = okParts;
    }

    public Integer getTotalProduction() {
        return totalProduction;
    }

    public void setTotalProduction(Integer totalProduction) {
        this.totalProduction = totalProduction;
    }

    public Integer getNotOkParts() {
        return notOkParts;
    }

    public void setNotOkParts(Integer notOkParts) {
        this.notOkParts = notOkParts;
    }

    public Integer getCurrentShift() {
        return currentShift;
    }

    public void setCurrentShift(Integer currentShift) {
        this.currentShift = currentShift;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSflPartId() {
        return sflPartId;
    }

    public void setSflPartId(String sflPartId) {
        this.sflPartId = sflPartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProcess1PassFail() {
        return process1PassFail;
    }

    public void setProcess1PassFail(Integer process1PassFail) {
        this.process1PassFail = process1PassFail;
    }

    public Double getProcess1Parameter1() {
        return process1Parameter1;
    }

    public void setProcess1Parameter1(Double process1Parameter1) {
        this.process1Parameter1 = process1Parameter1;
    }

    public Double getProcess1Parameter2() {
        return process1Parameter2;
    }

    public void setProcess1Parameter2(Double process1Parameter2) {
        this.process1Parameter2 = process1Parameter2;
    }

    public Double getProcess1Parameter3() {
        return process1Parameter3;
    }

    public void setProcess1Parameter3(Double process1Parameter3) {
        this.process1Parameter3 = process1Parameter3;
    }
}
