package com.MockService.SimahBank.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

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

    public String bronzeReportResponse () throws IOException, JSONException {


        JSONObject responseJsonObject = new JSONObject();
        String requiredJsonString = null;
        String keyToSearch = "levelTwoCISummary";
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("D:\\Temenos-First-Task\\Silver_Report_Response.json")));
            JSONObject jsonObject = new JSONObject(jsonData);
            requiredJsonString = findValueForKey(jsonObject, keyToSearch);
            try {
                JSONArray jsonArray = new JSONArray(requiredJsonString);
                responseJsonObject.put("demographicsDetail", jsonArray);
            }
            catch (JSONException e) {
                try {
                    JSONObject jsonResponse = new JSONObject(requiredJsonString);
                    responseJsonObject.put("demographicsDetail", jsonResponse);
                } catch (JSONException ex) {
                    System.err.println("Some error occured: " + ex.getMessage());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String jsonString = null;
        try {
            jsonString = readTextFromFile(filePath_bronzeReportResponse);
        } catch (IOException e) {
            jsonString = " Some Exception Occured While Reading The File";
        }
        String responseJsonString = responseJsonObject.toString(4);
        return responseJsonString;
    }

//    private static String findValueForKey(JSONObject jsonObject, String key) {
//        String value = null;
//        try {
//            // Check if the current JSONObject contains the key
//            if (jsonObject.has(key)) {
//                value = jsonObject.getString(key);
//            } else {
//                // If the key is not found, recursively search in nested JSONObjects
//                Iterator<String> keys = jsonObject.keys();
//                while (keys.hasNext()) {
//                    String nestedKey = keys.next();
//                    Object nestedObject = jsonObject.get(nestedKey);
//                    if (nestedObject instanceof JSONObject) {
//                        value = findValueForKey((JSONObject) nestedObject, key);
//                        if (value != null) {
//                            break;
//                        }
//                    }
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return value;
//    }

    private static String findValueForKey(JSONObject jsonObject, String key) {
        String value = null;
        try {
            // Check if the current JSONObject contains the key
            if (jsonObject.has(key)) {
                value = jsonObject.getString(key);
            } else {
                // If the key is not found, recursively search in nested JSONObjects
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String nestedKey = keys.next();
                    Object nestedObject = jsonObject.get(nestedKey);
                    if (nestedObject instanceof JSONObject) {
                        value = findValueForKey((JSONObject) nestedObject, key);
                        if (value != null) {
                            break;
                        }
                    } else if (nestedObject instanceof JSONArray) {
                        // Handle JSON array
                        JSONArray jsonArray = (JSONArray) nestedObject;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (jsonArray.get(i) instanceof JSONObject) {
                                value = findValueForKey(jsonArray.getJSONObject(i), key);
                                if (value != null) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

}
