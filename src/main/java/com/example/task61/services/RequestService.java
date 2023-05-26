package com.example.task61.services;

import com.example.task61.entities.AppRequest;

import java.util.List;

public interface RequestService {
    AppRequest addApp(AppRequest appRequest);

    List<AppRequest> getAllItems();
    void deleteApp(Long id);
    AppRequest getApp(Long id);
    AppRequest saveApp(AppRequest appRequest);
    List<AppRequest> getNewApps(boolean check);

    List<AppRequest> getCheckApps(boolean check);

}
