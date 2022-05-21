package service;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.PullImageResultCallback;
import com.github.dockerjava.api.model.PullResponseItem;
import docker.DockerInstance;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DockerService {

    private final DockerClient dockerClient = new DockerInstance().getClient();

    public void ping() {
        dockerClient.pingCmd().exec();
    }

    @SneakyThrows
    public void pullImage() {
        PullImageResultCallback resultCallback = new PullImageResultCallback();
        dockerClient.pullImageCmd("alpine:latest").exec(new PullImageResultCallback() {
            @Override
            public void onNext(PullResponseItem item) {
                super.onNext(item);
                System.out.println(item);
            }
        }).awaitCompletion();
    }
}
