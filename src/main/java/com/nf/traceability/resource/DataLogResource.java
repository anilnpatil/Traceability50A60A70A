package com.nf.traceability.resource;

import com.nf.traceability.dto.*;
import com.nf.traceability.service.LogDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map; 

@RestController
@RequestMapping(path = {"/", "/data"})
public class DataLogResource {
    Logger logger = LoggerFactory.getLogger(DataLogResource.class);
    
    @Autowired
    private LogDataService logDataService;

    @GetMapping("/getLogData")
    public Line1 getLogData() {
        return logDataService.sendLogResults();
    }

    @GetMapping("/getMachine1UpdatedData")
    public Machine1 getMachine1UpdatedData() {
        return logDataService.getUpdatedMachine1Data();
    }

    @GetMapping("/getMachine1UpdatedResults")
    public ArrayList<Machine1CSVData> getMachine1UpdatedResults() {
        return logDataService.getMachine1Data();
    }

    @GetMapping("/getMachine1FilteredData")
    public ArrayList<Machine1CSVData> filterMachine1UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine1FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine1DataUsingProductId")
    public ArrayList<Machine1CSVData> getMachine1DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine1DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine2UpdatedData")
    public Machine2 getMachine2UpdatedData() {
        return logDataService.getUpdatedMachine2Data();
    }

    @GetMapping("/getMachine2UpdatedResults")
    public ArrayList<Machine2CSVData> getMachine2UpdatedResults() {
        return logDataService.getMachine2Data();
    }

    @GetMapping("/getMachine2FilteredData")
    public ArrayList<Machine2CSVData> filterMachine2UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine2FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine2DataUsingProductId")
    public ArrayList<Machine2CSVData> getMachine2DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine2DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine3UpdatedData")
    public Machine3 getMachine3UpdatedData() {
        return logDataService.getUpdatedMachine3Data();
    }

    @GetMapping("/getMachine3UpdatedResults")
    public ArrayList<Machine3CSVData> getMachine3UpdatedResults() {
        return logDataService.getMachine3Data();
    }

    @GetMapping("/getMachine3FilteredData")
    public ArrayList<Machine3CSVData> filterMachine3UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine3FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine3DataUsingProductId")
    public ArrayList<Machine3CSVData> getMachine3DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine3DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine4UpdatedData")
    public Machine4 getMachine4UpdatedData() {
        return logDataService.getUpdatedMachine4Data();
    }

    @GetMapping("/getMachine4UpdatedResults")
    public ArrayList<Machine4CSVData> getMachine4UpdatedResults() {
        return logDataService.getMachine4Data();
    }

    @GetMapping("/getMachine4FilteredData")
    public ArrayList<Machine4CSVData> filterMachine4UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine4FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine4DataUsingProductId")
    public ArrayList<Machine4CSVData> getMachine4DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine4DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine5UpdatedData")
    public Machine5 getMachine5UpdatedData() {
        return logDataService.getUpdatedMachine5Data();
    }

    @GetMapping("/getMachine5UpdatedResults")
    public ArrayList<Machine5CSVData> getMachine5UpdatedResults() {
        return logDataService.getMachine5Data();
    }

    @GetMapping("/getMachine5FilteredData")
    public ArrayList<Machine5CSVData> filterMachine5UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine5FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine5DataUsingProductId")
    public ArrayList<Machine5CSVData> getMachine5DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine5DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine6UpdatedData")
    public Machine6 getMachine6UpdatedData() {
        return logDataService.getUpdatedMachine6Data();
    }

    @GetMapping("/getMachine6UpdatedResults")
    public ArrayList<Machine6CSVData> getMachine6UpdatedResults() {
        return logDataService.getMachine6Data();
    }

    @GetMapping("/getMachine6FilteredData")
    public ArrayList<Machine6CSVData> filterMachine6UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine6FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine6DataUsingProductId")
    public ArrayList<Machine6CSVData> getMachine6DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine6DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine7UpdatedData")
    public Machine7 getMachine7UpdatedData() {
        return logDataService.getUpdatedMachine7Data();
    }

    @GetMapping("/getMachine7UpdatedResults")
    public ArrayList<Machine7CSVData> getMachine7UpdatedResults() {
        return logDataService.getMachine7Data();
    }

    @GetMapping("/getMachine7FilteredData")
    public ArrayList<Machine7CSVData> filterMachine7UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine7FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine7DataUsingProductId")
    public ArrayList<Machine7CSVData> getMachine7DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine7DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine8UpdatedData")
    public Machine8 getMachine8UpdatedData() {
        return logDataService.getUpdatedMachine8Data();
    }

    @GetMapping("/getMachine8UpdatedResults")
    public ArrayList<Machine8CSVData> getMachine8UpdatedResults() {
        return logDataService.getMachine8Data();
    }

    @GetMapping("/getMachine8FilteredData")
    public ArrayList<Machine8CSVData> filterMachine8UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine8FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine8DataUsingProductId")
    public ArrayList<Machine8CSVData> getMachine8DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine8DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine9UpdatedData")
    public Machine9 getMachine9UpdatedData() {
        return logDataService.getUpdatedMachine9Data();
    }

    @GetMapping("/getMachine9UpdatedResults")
    public ArrayList<Machine9CSVData> getMachine9UpdatedResults() {
        return logDataService.getMachine9Data();
    }

    @GetMapping("/getMachine9FilteredData")
    public ArrayList<Machine9CSVData> filterMachine9UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine9FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine9DataUsingProductId")
    public ArrayList<Machine9CSVData> getMachine9DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine9DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine10UpdatedData")
    public Machine10 getMachine10UpdatedData() {
        return logDataService.getUpdatedMachine10Data();
    }

    @GetMapping("/getMachine10UpdatedResults")
    public ArrayList<Machine10CSVData> getMachine10UpdatedResults() {
        return logDataService.getMachine10Data();
    }

    @GetMapping("/getMachine10FilteredData")
    public ArrayList<Machine10CSVData> filterMachine10UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine10FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine10DataUsingProductId")
    public ArrayList<Machine10CSVData> getMachine10DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine10DataUsingProductId(prodId);
    }

    @GetMapping("/getMachine11UpdatedData")
    public Machine11 getMachine11UpdatedData() {
        return logDataService.getUpdatedMachine11Data();
    }

    @GetMapping("/getMachine11UpdatedResults")
    public ArrayList<Machine11CSVData> getMachine11UpdatedResults() {
        return logDataService.getMachine11Data();
    }

    @GetMapping("/getMachine11FilteredData")
    public ArrayList<Machine11CSVData> filterMachine11UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine11FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine11DataUsingProductId")
    public ArrayList<Machine11CSVData> getMachine11DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine11DataUsingProductId(prodId);
    }
    ////machine 12(70A) code//
    @GetMapping("/getMachine19UpdatedData")
    public Machine19 getMachine19UpdatedData() {
        return logDataService.getUpdatedMachine19Data();
    }

    @GetMapping("/getMachine19UpdatedResults")
    public ArrayList<Machine19CSVData> getMachine19UpdatedResults() {
        return logDataService.getMachine19Data();
    }

    @GetMapping("/getMachine19FilteredData")
    public ArrayList<Machine19CSVData> filterMachine19UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine19FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine19DataUsingProductId")
    public ArrayList<Machine19CSVData> getMachine19DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine19DataUsingProductId(prodId);
    }
    ////machine 13(50A) code//
    @GetMapping("/getMachine13UpdatedData")
    public Machine13 getMachine13UpdatedData() {
        return logDataService.getUpdatedMachine13Data();
    }

    @GetMapping("/getMachine13UpdatedResults")
    public ArrayList<Machine13CSVData> getMachine13UpdatedResults() {
        return logDataService.getMachine13Data();
    }

    @GetMapping("/getMachine13FilteredData")
    public ArrayList<Machine13CSVData> filterMachine13UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine13FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine13DataUsingProductId")
    public ArrayList<Machine13CSVData> getMachine13DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine13DataUsingProductId(prodId);
    }
    ////machine 14(60A) code//
    @GetMapping("/getMachine14UpdatedData")
    public Machine14 getMachine14UpdatedData() {
        return logDataService.getUpdatedMachine14Data();
    }

    @GetMapping("/getMachine14UpdatedResults")
    public ArrayList<Machine14CSVData> getMachine14UpdatedResults() {
        return logDataService.getMachine14Data();
    }

    @GetMapping("/getMachine14FilteredData")
    public ArrayList<Machine14CSVData> filterMachine14UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getMachine14FilteredData(fromDate, toDate);
    }

    @GetMapping("/getMachine14DataUsingProductId")
    public ArrayList<Machine14CSVData> getMachine14DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getMachine14DataUsingProductId(prodId);
    }


    @GetMapping("/getTotalProductionCount")
    public Integer getTotalProductionCount() {
        return logDataService.getTotalProductionCount();
    }

    @GetMapping("/getLine1UpdatedResults")
    public ArrayList<Line1CSVData> getLine1UpdatedResults() {
        return logDataService.getLine1ProductionData();
    }

    @GetMapping("/getLine1FilteredData")
    public ArrayList<Line1CSVData> filterLine1UsingDate(@RequestParam Map<String, String> requestParams) throws Exception{
        String fromDate = requestParams.get("fromDate");
        String toDate = requestParams.get("toDate");
        return logDataService.getLine1ProductionFilteredData(fromDate, toDate);
    }

    @GetMapping("/getLine1DataUsingProductId")
    public ArrayList<Line1CSVData> getLine1DataUsingProductId(@RequestParam Map<String, String> requestParams) throws Exception{
        String prodId = requestParams.get("prodId");
        return logDataService.getLine1ProductionDataUsingProductId(prodId);
    }

    @GetMapping("/getDailyReport")
    public Machine19 getDailyReport() {
        return logDataService.getDailyReport();
    }

    @GetMapping("/deleteLine1")
    public String deleteLine1(@RequestParam Map<String, String> requestParams) throws Exception{
        String endDate = requestParams.get("endDate");
        return logDataService.deleteLine1(endDate);
    }

    @GetMapping("/checkError")
    public ErrorInfo checkError() {
        return logDataService.checkError();
    }

    @GetMapping("/updateErrorStatus")
    public String updateErrorStatus() {
        return logDataService.updateErrorStatus();
    }
}
