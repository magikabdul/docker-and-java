package service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.PullImageResultCallback;
import docker.DockerInstance;
import lombok.SneakyThrows;

public class DockerService {

    private final DockerClient dockerClient = new DockerInstance().getClient();

    @SneakyThrows
    public void start() {
        dockerClient.pullImageCmd("openjdk:11-jdk").exec(new PullImageResultCallback()).awaitCompletion();

//        dockerClient.createContainerCmd("openjdk:11-jdk")
//                .withCmd("ls")
//                .exec();
    }
}
