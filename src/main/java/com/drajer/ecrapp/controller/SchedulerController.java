package com.drajer.ecrapp.controller;

import com.drajer.ecrapp.model.ScheduledTasks;
import com.drajer.ecrapp.service.SchedulerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchedulerController {

  private final Logger logger = LoggerFactory.getLogger(SchedulerController.class);

  @Autowired SchedulerService schedulerService;

  @CrossOrigin
  @GetMapping("/api/scheduledTasks")
  public List<ScheduledTasks> getScheduledTasks(
      @RequestParam(name = "action", required = false) String actionType,
      @RequestParam(name = "patient", required = false) String patientId,
      @RequestParam(name = "encounter", required = false) String encounterId,
      @RequestParam(name = "launch", required = false) String launchId) {

    logger.info(
        "Received request to get Scheduled Tasks by action:{},patient:{},encounter:{} and launch:{}",
        actionType,
        patientId,
        encounterId,
        launchId);
    List<ScheduledTasks> tasksList =
        schedulerService.getScheduledTasks(actionType, patientId, encounterId, launchId);
    return tasksList;
  }
}