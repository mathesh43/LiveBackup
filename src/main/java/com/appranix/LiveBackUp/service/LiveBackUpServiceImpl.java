package com.appranix.LiveBackUp.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appranix.LiveBackUp.domain.entity.LiveBackUp;
import com.appranix.LiveBackUp.domain.repository.LiveBackUpRepository;
import com.appranix.LiveBackUp.web.LiveBackUpRestController;
import com.fasterxml.jackson.core.JsonParser;

@Service
public class LiveBackUpServiceImpl {
	
	private static final Logger logger = LoggerFactory
            .getLogger(LiveBackUpServiceImpl.class);

    @Autowired
    private LiveBackUpRepository liveBackUpRepository;
    
	

    public LiveBackUp createBackUp(LiveBackUp liveBackUp) {
    	
         JSONObject req_payload = new JSONObject();
         try {
			req_payload.put("name", "liveBackUp");
			req_payload.put("owner", "mathesh");
	         req_payload.put("ownerEmail", "mathesh@appranix.com");
	         req_payload.put("description", "Sample  live back up job giving to scheduler");
	         req_payload.put("schedule", "@every 5m");
	         req_payload.put("command", "docker run --rm docker-image");
	         req_payload.put("shell", "false");
		} catch (JSONException e) {
			logger.error("JSONException caught.");
			logger.debug("JSONException caught. " + e.getMessage());
		}
         
         String request = req_payload.toString();
         logger.info(request);
         

         String url = "http://i00071-az-sind.hosts.appranix.info:6838/api/job/";

    	 HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         headers.setAccept((List<MediaType>) Arrays.asList(MediaType.APPLICATION_JSON));
         HttpEntity<String> entity = new HttpEntity<String>(request, headers);
         RestTemplate restTemplate = new RestTemplate();
         ResponseEntity<String> orgListResponse = restTemplate.postForEntity(url, entity, String.class);
        
         if (orgListResponse.getStatusCode() == HttpStatus.CREATED) {
				String responseBody = orgListResponse.getBody().toString();
				String schedulerRefId = null;
				
				try {
					JSONObject dockerImages = new JSONObject(responseBody);
					schedulerRefId = dockerImages.get("id").toString();
				} catch (JSONException e) {
					logger.error("JSONException caught.");
					logger.debug("JSONException caught. " + e.getMessage());
				}
				if (schedulerRefId == null) {
					logger.error("could not create task for given response.");
					return null;
				}
				liveBackUp.setSchedulerRefId(schedulerRefId);
                save(liveBackUp);
         }
		return liveBackUp; 
    }
     
    private LiveBackUp save(LiveBackUp liveBackUp) {
    	return liveBackUpRepository.save(liveBackUp);
    }

    public Iterable<LiveBackUp> findAll() {
        return liveBackUpRepository.findAll();
    }
    
    public void deleteBackUp(Long id) {
    		liveBackUpRepository.delete(id);
    }
    
//	Iterable<LiveBackUp> liveBackUps = liveBackUpRepository.findByEnvironmentId(environmentId);
//	for (LiveBackUp liveBackUp : liveBackUps) {
//		Long id = liveBackUp.getId();
//		liveBackUpRepository.delete(id);
//	}

    public Iterable<LiveBackUp> findByEnvironmentId(String environmentId) {
    	Iterable<LiveBackUp> liveBackUps = liveBackUpRepository.findByEnvironmentId(environmentId);
    	return liveBackUps;
    }
    
}
