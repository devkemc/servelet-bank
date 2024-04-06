package br.com.devkemc.serveletbank;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Run {

    public static void main(String[] args) throws Exception {
        String resourcesLocation = "src/main/webapp/";

        Tomcat tomcat = new Tomcat();

        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }
        tomcat.setPort(Integer.valueOf(webPort));

        System.out.println("Configuring app with base dir: " + new File("./" + resourcesLocation).getAbsolutePath() + "...");

        StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File(resourcesLocation).getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));

        ctx.setResources(resources);
        tomcat.enableNaming();
        tomcat.getConnector();

        try {
            System.out.println("Starting Tomcat...");
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();

    }

}
