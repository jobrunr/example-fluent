package org.jobrunr.example;

import org.jobrunr.configuration.JobRunr;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.storage.InMemoryStorageProvider;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        JobRunr.configure()
                .useStorageProvider(new InMemoryStorageProvider())
                .useBackgroundJobServer()
                .useDashboard()
                .initialize();

        BackgroundJob.enqueue(() -> System.out.println("Simple!"));

        Thread.currentThread().join();
    }

}
