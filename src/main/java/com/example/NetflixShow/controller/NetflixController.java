package com.example.NetflixShow.controller;

import com.example.NetflixShow.domain.ShowDetails;
import com.example.NetflixShow.service.ShowDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NetflixController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NetflixController.class);

    @Autowired
    private ShowDetailsService showDetailsService;

    @RequestMapping("/feedData")
    public void setDataInDB() throws Exception {
        showDetailsService.insertToDb();
    }

    @GetMapping("/tvshows")
    public ResponseEntity getShowData(@RequestHeader(value = "X-Auth-Token",required = false) String token,@RequestParam Map<String, String> params){

        if(token== null || token.length() == 0){
            System.out.println("bad request");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("X-Auth-Token is not present in the request.");
        }

        long time = System.currentTimeMillis();
        HttpHeaders header = new HttpHeaders();
        List<ShowDetails> detailsList = showDetailsService.findByInput(params);
        header.add("X-TIME-TO-EXECUTE", (System.currentTimeMillis() - time) + " ms");
        return new ResponseEntity<>(detailsList,header,HttpStatus.OK);
    }

    @PostMapping("/shows")
    public ResponseEntity<ShowDetails> postData(@RequestBody ShowDetails showDetails){
        ShowDetails details = showDetailsService.postData(showDetails);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
