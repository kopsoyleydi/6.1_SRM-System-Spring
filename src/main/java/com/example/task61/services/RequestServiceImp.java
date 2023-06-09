package com.example.task61.services;


import com.example.task61.entities.AppRequest;
import com.example.task61.repository.AppReposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImp implements RequestService{
    @Autowired
    private AppReposRepository appRepos;
    @Override
    public AppRequest addApp(AppRequest appRequest) {
        return appRepos.save(appRequest);
    }

    @Override
    public List<AppRequest> getAllItems() {
        return appRepos.findAll();
    }

    @Override
    public void deleteApp(Long id) {
        appRepos.deleteById(id);
    }

    @Override
    public AppRequest getApp(Long id) {
        return appRepos.findAllById(id);
    }
    public List<AppRequest> getNewApps(boolean check){
        return appRepos.findAllByHandledEquals(check);
    }
    @Override
    public AppRequest saveApp(AppRequest appRequest) {
        return appRepos.save(appRequest);
    }

    @Override
    public List<AppRequest> getCheckApps(boolean check){
        return appRepos.findAllByHandledEquals(check);
    }
}
