package com.example.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")  // All resources under /api
public class RestApplication extends Application {
    // No need to override getClasses() if using auto-discovery (Jersey does it)
}