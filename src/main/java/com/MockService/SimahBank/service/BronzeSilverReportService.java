package com.MockService.SimahBank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class BronzeSilverReportService {

    private static final Logger logger = LoggerFactory.getLogger(BronzeSilverReportService.class);

    @Value("${filePath_silverReportResponse}")
    public String filePath_silverReportResponse;

    @Value("${filePath_bronzeReportResponse}")
    public String filePath_bronzeReportResponse;

    public String readTextFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        logger.info("Simah service  - readTextFromFile - path ="+filePath);

        try{
            byte[] bytes = Files.readAllBytes(path);
            String encodedString = new String(bytes, "UTF-8");
            return new String(encodedString);
        }
        catch (Exception ex){

            return  "EXCEPTION OCCURRED WHILE READING API RESPONSE FROM FILE (METHODNAME readTextFromFile()) ---MSG == " + ex.getMessage();
        }

    }

    public String silverReportResponse ()  {

        String jsonString = null;
        logger.info("File path in for Bronze response "+ filePath_silverReportResponse);

        try {
            jsonString = readTextFromFile(filePath_silverReportResponse);
        } catch (IOException e) {
            jsonString =" Some Exception Occured While Reading The File";
            logger.info("Simah silverReportResponse - AUTO COMPLETE - Exception Occured   -- returning back from mack service");
        }

        return jsonString;
    }

    public String bronzeReportResponse ()  {

        String jsonString = null;
        try {
            jsonString = readTextFromFile(filePath_bronzeReportResponse);
        } catch (IOException e) {
            jsonString =" Some Exception Occured While Reading The File";
        }
        //logger.info("Simba bronzeReportResponse - AUTO COMPLETE - Read file successfully   -- returning back from mack service");
        return jsonString;
    }
}
