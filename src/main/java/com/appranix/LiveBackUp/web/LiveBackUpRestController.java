package com.appranix.LiveBackUp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appranix.LiveBackUp.domain.entity.LiveBackUp;
import com.appranix.LiveBackUp.service.LiveBackUpServiceImpl;

import org.json.JSONException;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/live-backup")
@Component
public class LiveBackUpRestController {

	private static final Logger logger = LoggerFactory
            .getLogger(LiveBackUpRestController.class);
	
    @Autowired
    private LiveBackUpServiceImpl liveBackUpServiceImpl;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public LiveBackUp createBackUp(@RequestBody LiveBackUp liveBackUp) {
    	logger.info("Create live backup.");
        LiveBackUp live =  liveBackUpServiceImpl.createBackUp(liveBackUp);
        return live;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteBackUp(@RequestParam("id") Long id) throws JSONException {
        liveBackUpServiceImpl.deleteBackUp(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<LiveBackUp> getAllDetails() {
        return liveBackUpServiceImpl.findAll();
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<LiveBackUp> getDetails(@RequestParam("environmentId") String environmentId) {
        return liveBackUpServiceImpl.findByEnvironmentId(environmentId);
    }
}
